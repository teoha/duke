package duke.command;

import duke.*;
import duke.exception.EmptyDescriptionException;
import duke.task.Deadline;
import duke.task.Task;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddDeadlineCommand extends AddCommand {
  private String description;
  private String date;

  public AddDeadlineCommand(String description, String date) {
    this.description = description;
    this.date = date;
  }

  @Override
  public void execute(TaskList tasks, Ui ui, Storage storage)
      throws IOException, EmptyDescriptionException, ParseException {
    Date deadlineDate = new SimpleDateFormat("dd/MM/yyyy hhmm").parse(date);
    Task task = new Deadline(description, deadlineDate);
    tasks.add(task);
    ui.showTaskAddedMessage(task, tasks);
    storage.saveDeadLine(description, date);
  }

  @Override
  public boolean isExit() {
    return false;
  }
}
