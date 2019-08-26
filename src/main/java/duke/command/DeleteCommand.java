package duke.command;

import duke.*;
import duke.exception.EmptyDescriptionException;
import duke.task.Task;
import java.io.IOException;
import java.text.ParseException;

public class DeleteCommand extends Command {
  private int index;

  public DeleteCommand(int index) {
    this.index = index;
  }

  @Override
  public void execute(TaskList tasks, Ui ui, Storage storage)
      throws IOException, EmptyDescriptionException, ParseException {
    Task task = tasks.getByIndex(index);
    tasks.delete(index);
    ui.showDeleteMessage(task, tasks);
  }

  @Override
  public boolean isExit() {
    return false;
  }
}
