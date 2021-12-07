package manager.io;

import manager.model.State;
import manager.model.Task;

import java.util.List;

public abstract class Tools {
    public static String printTasks(List<Task> taskList) {
        StringBuilder sb = new StringBuilder();

        for (Task task : taskList) {
            sb.append(String.format("%d [%s] %s\n", task.getId(), task.getState() == State.DONE ? "x" : " ", task.getDescription()));
        }

        System.out.println(sb);

        return sb.toString();
    }
}
