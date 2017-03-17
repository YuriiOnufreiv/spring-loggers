package ua.onufreiv.logger;

import ua.onufreiv.logger.event.Event;

/**
 * Created by Yurii_Onufreiv on 17-Mar-17.
 */
public class ConsoleEventLogger implements EventLogger {
    public void logEvent(Event event) {
        System.out.println(event);
    }
}
