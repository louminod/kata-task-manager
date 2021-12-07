package tests;

import manager.io.IOFakeImpl;
import manager.io.IOInterface;
import manager.io.Interpreter;
import manager.model.Action;
import manager.model.Instruction;
import manager.model.Task;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
