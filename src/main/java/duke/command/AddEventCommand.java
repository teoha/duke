package duke.command;

import duke.*;
import duke.exception.EmptyDescriptionException;
import duke.task.Event;
import duke.task.Task;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddEventCommand extends AddCommand{
    private String description;
    private String duration;

    public AddEventCommand(String description, String duration) {
        this.description = description;
        this.duration = duration;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws IOException, EmptyDescriptionException, ParseException {
        Date start = new SimpleDateFormat("dd/MM/yyyy hhmm").parse(duration.split("-")[0].trim());
        Date end = new SimpleDateFormat("dd/MM/yyyy hhmm").parse(duration.split("-")[1].trim());

        Task task = new Event(description, start, end);
        tasks.add(task);
        ui.showTaskAddedMessage(task,tasks);

        storage.saveEvent(description, duration);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
