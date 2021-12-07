package tests;

import manager.io.IOFakeImpl;
import manager.io.IOInterface;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserInputTest {
    @Test
    public void testReadUserInput() {
        IOInterface io = new IOFakeImpl("+ Learn Rust");
        String input = io.readInput();
        assertEquals("+ Learn Rust", input);
    }
}
