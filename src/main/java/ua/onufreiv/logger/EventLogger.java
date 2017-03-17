package ua.onufreiv.logger;

import ua.onufreiv.logger.event.Event;

/**
 * Created by Yurii_Onufreiv on 17-Mar-17.
 */
public interface EventLogger {
    void logEvent(Event event);
}
