package duke.task;

import java.util.Date;

/**
 * Represents an event task.
 */
public class Event extends Task {
    private Date start;
    private Date end;

    public Event(String description, Date start, Date end) {
        super(description);
        this.start = start;
        this.end = end;
    }

    /**
     * Returns the duration of the event separated by a dash.
     * @return A string representation of the duration of the event.
     */
    public String getDurationString() {
        return String.format("%02d/%02d/%02d %02d%02d - %02d/%02d/%02d %02d%02d"
                ,start.getDate(), start.getMonth(), start.getYear(), start.getHours(),start.getMinutes()
                ,end.getDate(), end.getMonth(), end.getYear(), end.getHours(),end.getMinutes());
    }

    /**
     * Returns a description of the properties of the task.
     * @return a string representation of the task.
     */
    @Override
    public String toString() {
        return String.format("[E]%s (at: %s - %s)",super.toString(),start, end);
    }
}
