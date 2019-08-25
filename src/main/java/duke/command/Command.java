package duke.command;

import duke.exception.EmptyDescriptionException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;

import java.io.IOException;
import java.text.ParseException;

public abstract class Command {
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws IOException, EmptyDescriptionException, ParseException;
    public abstract boolean isExit();

}
