package manager.io;

public class IOFakeImpl implements IOInterface {
    private String input;

    public IOFakeImpl(String input) {
        this.input = input;
    }

    @Override
    public String readInput() {
        return this.input;
    }
}
