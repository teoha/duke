package duke.task;

import java.util.Date;

/**
 * Represents a deadline task.
 */
public class Deadline extends Task{
    private Date date;

    public Deadline(String description, Date date) {
        super(description);
        this.date = date;
    }

    /**
     * Returns the date of the deadline in numerical format.
     * @return A string representation of the date of the deadline.
     */
    public String getDateString() {
        return String.format("%02d/%02d/%02d %02d%02d",date.getDate(), date.getMonth(), date.getYear(), date.getHours(),date.getMinutes());
    }
    /**
     * Returns a description of the properties of the task.
     * @return a string representation of the task.
     */
    @Override
    public String toString() {
        return String.format("[D]%s (by: %s)",super.toString(),date);
    }
}
