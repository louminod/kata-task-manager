package manager.model;

public class Task {
    private static int id;
    private State state;
    private final String description;

    public Task(State state, String description) {
        Task.id += 1;
        this.state = state;
        this.description = description;
    }

    public static int getId() {
        return Task.id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }
}
