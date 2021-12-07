package manager.model;

public class Task {
    private static int count;
    private final int id;
    private State state;
    private final String description;

    public Task(State state, String description) {
        count++;
        this.id = count;
        this.state = state;
        this.description = description;
    }

    public int getId() {
        return this.id;
    }

    public static int getCount() {
        return Task.count;
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
