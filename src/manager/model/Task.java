package manager.model;

public class Task {
    private final int id;
    private State state;
    private final String description;

    public Task(int id, State state, String description) {
        this.id = id;
        this.state = state;
        this.description = description;
    }

    public int getId() {
        return id;
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
