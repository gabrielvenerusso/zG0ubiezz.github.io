import java.text.SimpleDateFormat;
import java.util.Date;

class ConsoleLogger implements Logger{
    @Override
    public String log(String message, LogLevel level) {
        String formattedMessage = getFormattedMessage(message, level);
        logToConsole(formattedMessage);
        return formattedMessage;
    }

    private void logToConsole(String message) {
        System.out.println(message);
    }

    private String getFormattedMessage(String message, LogLevel level) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = dateFormat.format(new Date());
        String color = getColor(level);

        return String.format("[%s] %s %s: %s", currentTime, color, level.name(), message);
    }

    private String getColor(LogLevel level) {
        switch (level) {
            case DEBUG:
                return "\u001B[32m"; // Green
            case WARNING:
                return "\u001B[33m"; // Yellow
            case ERROR:
                return "\u001B[31m"; // Red
            default:
                return "";
        }
    }
}
