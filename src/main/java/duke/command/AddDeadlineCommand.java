package duke.command;

import duke.*;
import duke.exception.EmptyDescriptionException;
import duke.task.Deadline;
import duke.task.Task;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents command to add a deadline task into task list which has yet to be executed.
 */
public class AddDeadlineCommand extends AddCommand {
  private String description;
  private String date;

  public AddDeadlineCommand(String description, String date) {
    this.description = description;
    this.date = date;
  }

    /**
     * Adds a deadline into the task list.
     * @param tasks Current list of tasks
     * @param ui UI being used
     * @param storage Current storage in use
     * @throws IOException Error with accessing file or file writer
     * @throws EmptyDescriptionException Error when no description is provided
     * @throws ParseException Error when incorrect format for date is used
     */
  @Override
  public void execute(TaskList tasks, Ui ui, Storage storage)
      throws IOException, EmptyDescriptionException, ParseException {
    Date deadlineDate = new SimpleDateFormat("dd/MM/yyyy hhmm").parse(date);
    Task task = new Deadline(description, deadlineDate);
    tasks.add(task);
    ui.showTaskAddedMessage(task, tasks);
    storage.saveDeadLine(description, date);
  }

    /**
     * Test Exit Command.
     * @return Whether command is an Exit Command
     */
  @Override
  public boolean isExit() {
    return false;
  }
}
