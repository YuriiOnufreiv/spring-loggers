package ua.onufreiv;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.onufreiv.logger.EventLogger;
import ua.onufreiv.logger.event.Event;
import ua.onufreiv.logger.event.EventType;

import java.util.Map;

/**
 * Created by Yurii_Onufreiv on 17-Mar-17.
 */
public class App {
    public static ConfigurableApplicationContext context;

    static {
        context = new ClassPathXmlApplicationContext(new String[]{"spring.xml"});
    }

    private Client client;
    private Map<EventType, EventLogger> loggers;
    private EventLogger defaultLogger;

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggers = loggers;
    }

    public void logEvent(String msg, EventType type) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        Event event = (Event) context.getBean("event");
        event.setMsg(message);

        EventLogger logger = loggers.get(type);
        if(logger == null) {
            logger = defaultLogger;
        }

        logger.logEvent(event);
    }

    public static void main(String[] args) {
        App app = (App) context.getBean("app");
        app.logEvent("Event for user 1", EventType.ERROR);

        context.registerShutdownHook();
    }
}
