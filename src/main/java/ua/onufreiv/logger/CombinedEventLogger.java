package ua.onufreiv.logger;

import ua.onufreiv.logger.event.Event;

import java.util.List;

/**
 * Created by Yurii_Onufreiv on 17-Mar-17.
 */
public class CombinedEventLogger implements EventLogger {
    private List<EventLogger> loggers;

    public CombinedEventLogger(List<EventLogger> loggers) {
        this.loggers = loggers;
    }

    public void logEvent(Event event) {
        for(EventLogger logger : loggers) {
            logger.logEvent(event);
        }
    }
}
