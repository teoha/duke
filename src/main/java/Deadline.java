import java.util.Date;

public class Deadline extends Task{
    private Date date;

    public Deadline(String description, Date date) {
        super(description);
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("[D]%s (by: %s)",super.toString(),date);
    }
}
