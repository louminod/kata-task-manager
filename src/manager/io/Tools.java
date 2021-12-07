package manager.io;

import manager.model.State;
import manager.model.Task;

import java.util.List;

public abstract class Tools {
    public static String printTasks(List<Task> taskList) {
        StringBuilder sb = new StringBuilder();

        int index = 1;
        for (Task task : taskList) {
            sb.append(String.format("%d [%s] %s", task.getId(), task.getState() == State.DONE ? "x" : " ", task.getDescription()));
            if (index != taskList.size()) {
                sb.append("\n");
            }
            index++;
        }

        System.out.println(sb);

        return sb.toString();
    }
}
