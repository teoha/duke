import java.io.IOException;
import java.text.ParseException;

public abstract class Command {
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws IOException, EmptyDescriptionException, ParseException;
    public abstract boolean isExit();

}
