package ua.onufreiv.logger;

import org.apache.commons.io.FileUtils;
import ua.onufreiv.logger.event.Event;

import java.io.File;
import java.io.IOException;

/**
 * Created by Yurii_Onufreiv on 17-Mar-17.
 */
public class FileEventLogger implements EventLogger {
    private String filename;

    public FileEventLogger(String filename) {
        this.filename = filename;
    }

    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(new File(filename), event.toString() + "\n", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() throws IOException {
        System.out.println("In FileEventLogger.init()");
        if(!(new File(filename).canWrite())) {
            throw new IOException();
        }
    }
}
