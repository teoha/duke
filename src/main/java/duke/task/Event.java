package duke.task;

import java.util.Date;

public class Event extends Task {
    private Date start;
    private Date end;

    public Event(String description, Date start, Date end) {
        super(description);
        this.start = start;
        this.end = end;
    }

    public String getDurationString() {
        return String.format("%02d/%02d/%02d %02d%02d - %02d/%02d/%02d %02d%02d"
                ,start.getDate(), start.getMonth(), start.getYear(), start.getHours(),start.getMinutes()
                ,end.getDate(), end.getMonth(), end.getYear(), end.getHours(),end.getMinutes());
    }

    @Override
    public String toString() {
        return String.format("[E]%s (at: %s - %s)",super.toString(),start, end);
    }
}
