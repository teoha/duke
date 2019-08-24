import java.util.Date;

public class Event extends Task {
    private Date start;
    private Date end;

    public Event(String description, Date start, Date end) {
        super(description);
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return String.format("[E]%s (at: %s - %s)",super.toString(),start, end);
    }
}
