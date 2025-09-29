import java.util.Scanner;

class ConsoleInput implements InputDevice {
    private static final Scanner SCANNER = new Scanner(System.in);

    public String getInput() {
        return SCANNER.nextLine();
    }
}
