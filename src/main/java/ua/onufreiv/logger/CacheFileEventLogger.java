package ua.onufreiv.logger;

import ua.onufreiv.logger.event.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yurii_Onufreiv on 17-Mar-17.
 */
public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger(String filename, int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
        cache = new ArrayList<Event>();
    }

    private void writeEventsFromCache() {
        for(Event e : cache) {
            super.logEvent(e);
        }
        cache.clear();
    }

    public void destroy() {
        System.out.println("In CacheFileEventLogger.destroy()");
        if(!cache.isEmpty()) {
            writeEventsFromCache();
        }
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if(cache.size() == cacheSize) {
            writeEventsFromCache();
        }
    }
}
