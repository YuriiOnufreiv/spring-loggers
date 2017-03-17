package ua.onufreiv.logger.event;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Yurii_Onufreiv on 17-Mar-17.
 */
public class Event {
    private int id;
    private String msg;
    private Date date;
    private DateFormat dateFormat;

    public Event() {
        id = new Random().nextInt(100);
    }

    public Event(Date date, DateFormat dateFormat) {
        this();
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", date=" + dateFormat.format(date) +
                ", msg='" + msg + '\'' +
                '}';
    }
}
