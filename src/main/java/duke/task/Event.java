package duke.task;

import java.util.Date;

/** Represents an event task. */
public class Event extends Task {
    private Date start;
    private Date end;

    /**
     * Creates an event that comprises a start and end time.
     *
     * @param description Description of the event.
     * @param start Starting time of the event.
     * @param end Ending time of the event.
     */
    public Event(String description, Date start, Date end) {
        super(description);
        this.start = start;
        this.end = end;
    }

    /**
     * Returns the duration of the event separated by a dash.
     *
     * @return A string representation of the duration of the event.
     */
    public String getDurationString() {
        return String.format(
                "%02d/%02d/%04d %02d%02d - %02d/%02d/%04d %02d%02d",
                start.getDate(),
                start.getMonth(),
                start.getYear() + 1900,
                start.getHours(),
                start.getMinutes(),
                end.getDate(),
                end.getMonth(),
                end.getYear() + 1900,
                end.getHours(),
                end.getMinutes());
    }

    /**
     * Returns a description of the properties of the task.
     *
     * @return a string representation of the task.
     */
    @Override
    public String toString() {
        return String.format("[E]%s (at: %s)", super.toString(), getDurationString());
    }
}
