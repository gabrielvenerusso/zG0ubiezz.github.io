import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

class FileLogger implements Logger {
    private static final String FILE = "log.txt";
    private PrintWriter fileWriter;

    public FileLogger() {
        try {
            fileWriter = new PrintWriter(new FileWriter(FILE, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String log(String message, LogLevel level) {
        String formattedMessage = getFormattedMessage(message, level);
        logToFile(formattedMessage);
        return formattedMessage;
    }

    private void logToFile(String message) {
        fileWriter.println(message);
        fileWriter.flush();
    }

    private String getFormattedMessage(String message, LogLevel level) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = dateFormat.format(new Date());

        return String.format("[%s] %s: %s", currentTime, level.name(), message);
    }
}
