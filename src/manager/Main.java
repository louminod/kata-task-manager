package manager;

import manager.io.IOImpl;
import manager.io.IOInterface;
import manager.io.Interpreter;
import manager.io.Tools;
import manager.model.Action;
import manager.model.Instruction;
import manager.model.Task;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        IOInterface io = new IOImpl();

        System.out.println("No task yet");

        List<Task> taskList = new ArrayList<>();

        while (true) {
            Instruction instruction = Interpreter.interpretUserInput(io.readInput());
            Interpreter.interpretInstruction(taskList, instruction);

            if (instruction.action() != Action.EXIT) {
                Tools.printTasks(taskList);
            } else {
                break;
            }
        }
    }
}
