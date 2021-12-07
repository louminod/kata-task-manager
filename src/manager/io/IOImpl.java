package manager.io;

import java.util.Scanner;

public class IOImpl implements IOInterface {
    @Override
    public String readInput() {
        return new Scanner(System.in).nextLine();
    }
}
