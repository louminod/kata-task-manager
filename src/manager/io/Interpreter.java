package manager.io;

import manager.model.Action;
import manager.model.Instruction;

public class Interpreter {
    public Instruction interpret(String input) {
        Action action = null;
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
}
