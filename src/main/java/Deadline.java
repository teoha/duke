import java.util.Date;

public class Deadline extends Task{
    private Date date;

    public Deadline(String description, Date date) {
        super(description);
        this.date = date;
    }

    public String getDateString() {
        return String.format("%02d/%02d/%02d %02d%02d",date.getDay(), date.getMonth(), date.getYear(), date.getHours(),date.getMinutes());
    }

    @Override
    public String toString() {
        return String.format("[D]%s (by: %s)",super.toString(),date);
    }
}
