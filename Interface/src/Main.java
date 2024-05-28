import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Logger onConsole = new ConsoleLogger();
        Logger onFile = new FileLogger();

        onConsole.log("Debug", LogLevel.DEBUG);
        onConsole.log("Warning", LogLevel.WARNING);
        onConsole.log("Error", LogLevel.ERROR);

        onFile.log("Debug", LogLevel.DEBUG);
        onFile.log("Warning", LogLevel.WARNING);
        onFile.log("Error", LogLevel.ERROR);
    }
}