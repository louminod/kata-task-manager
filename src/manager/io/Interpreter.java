package manager.io;

import manager.model.Action;
import manager.model.Instruction;
import manager.model.State;
import manager.model.Task;

import java.util.List;

public class Interpreter {
    public Instruction interpretUserInput(String input) {
        String inputAction = input.split(" ")[0];

        switch (inputAction) {
            case "+" -> {
                return new Instruction(Action.ADD, input.substring(2));
            }
            case "-" -> {
                return new Instruction(Action.REMOVE, input.substring(2));
            }
            case "x" -> {
                return new Instruction(Action.DONE, input.substring(2));
            }
            case "o" -> {
                return new Instruction(Action.TODO, input.substring(2));
            }
            case "q" -> {
                return new Instruction(Action.EXIT, null);
            }
        }
        return null;
    }

    public Task interpretInstruction(List<Task> taskList, Instruction instruction) {
        int id = taskList.size() == 0 ? 1 : taskList.get(taskList.size() - 1).getId() + 1;

        switch (instruction.action()) {
            case ADD -> {
                Task task = new Task(id, State.TODO, instruction.parameter());
                taskList.add(task);
                return task;
            }
            case REMOVE -> {
                Task taskToRemove = getTaskWithId(taskList, Integer.parseInt(instruction.parameter()));
                taskList.remove(taskToRemove);
                return taskToRemove;
            }
            case DONE -> {
                Task taskToUpdate = getTaskWithId(taskList, Integer.parseInt(instruction.parameter()));
                taskToUpdate.setState(State.DONE);
                return taskToUpdate;
            }
            case TODO -> {
                Task taskToUpdate = getTaskWithId(taskList, Integer.parseInt(instruction.parameter()));
                taskToUpdate.setState(State.TODO);
                return taskToUpdate;
            }
            case EXIT -> {
                System.out.println("Bye!");
                return null;
            }
        }
        return null;
    }

    Task getTaskWithId(List<Task> taskList, int id) {
        for (Task task : taskList) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
}
