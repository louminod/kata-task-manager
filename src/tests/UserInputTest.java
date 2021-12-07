package tests;

import manager.io.IOFakeImpl;
import manager.io.IOInterface;
import manager.io.Interpreter;
import manager.model.Action;
import manager.model.Instruction;
import manager.model.State;
import manager.model.Task;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class UserInputTest {
    private Interpreter interpreter = new Interpreter();

    @Test
    public void testReadUserInput() {
        IOInterface io = new IOFakeImpl("+ Learn Rust");
        String input = io.readInput();
        assertEquals("+ Learn Rust", input);
    }

    @Test
    public void testUserInputInterpretationAddAction() {
        IOInterface io = new IOFakeImpl("+ Learn Rust");
        String input = io.readInput();
        Instruction instruction = interpreter.interpretUserInput(input);
        assertEquals(Action.ADD, instruction.action());
    }

    @Test
    public void testUserInputInterpretationAddDescription() {
        IOInterface io = new IOFakeImpl("+ Learn Rust");
        String input = io.readInput();
        Instruction instruction = interpreter.interpretUserInput(input);
        assertEquals("Learn Rust", instruction.parameter());
    }

    @Test
    public void testUserInputInterpretationRemoveAction() {
        IOInterface io = new IOFakeImpl("- 1");
        String input = io.readInput();
        Instruction instruction = interpreter.interpretUserInput(input);
        assertEquals(Action.REMOVE, instruction.action());
    }

    @Test
    public void testUserInputInterpretationDoneAction() {
        IOInterface io = new IOFakeImpl("x 1");
        String input = io.readInput();
        Instruction instruction = interpreter.interpretUserInput(input);
        assertEquals(Action.DONE, instruction.action());
    }

    @Test
    public void testUserInputInterpretationTodoAction() {
        IOInterface io = new IOFakeImpl("o 1");
        String input = io.readInput();
        Instruction instruction = interpreter.interpretUserInput(input);
        assertEquals(Action.TODO, instruction.action());
    }

    @Test
    public void testUserInputInterpretationExitAction() {
        IOInterface io = new IOFakeImpl("q");
        String input = io.readInput();
        Instruction instruction = interpreter.interpretUserInput(input);
        assertEquals(Action.EXIT, instruction.action());
    }

    @Test
    public void testAddInstruction() {
        List<Task> taskList = new ArrayList<>();
        IOInterface io = new IOFakeImpl("+ Learn Rust");
        String input = io.readInput();
        Instruction instruction = interpreter.interpretUserInput(input);
        Task task = interpreter.interpretInstruction(taskList, instruction);
        assertEquals(taskList.get(taskList.size() - 1).getId(), task.getId());
    }

    @Test
    public void testRemoveInstruction() {
        final int ID = 1;
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(ID, State.TODO, ""));
        IOInterface io = new IOFakeImpl(String.format("- %d", ID));
        String input = io.readInput();
        Instruction instruction = interpreter.interpretUserInput(input);
        interpreter.interpretInstruction(taskList, instruction);
        boolean exist = false;
        for (Task t : taskList) {
            if (t.getId() == ID) {
                exist = true;
                break;
            }
        }
        assertFalse(exist);
    }

    @Test
    public void testDoneInstruction() {
        final int ID = 1;
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(ID, State.TODO, ""));
        IOInterface io = new IOFakeImpl(String.format("x %d", ID));
        String input = io.readInput();
        Instruction instruction = interpreter.interpretUserInput(input);
        Task task = interpreter.interpretInstruction(taskList, instruction);
        assertEquals(State.DONE, task.getState());
    }

    @Test
    public void testTodoInstruction() {
        final int ID = 1;
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(ID, State.DONE, ""));
        IOInterface io = new IOFakeImpl(String.format("o %d", ID));
        String input = io.readInput();
        Instruction instruction = interpreter.interpretUserInput(input);
        Task task = interpreter.interpretInstruction(taskList, instruction);
        assertEquals(State.TODO, task.getState());
    }
}
