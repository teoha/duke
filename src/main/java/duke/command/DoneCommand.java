package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Task;
import java.io.IOException;

public class DoneCommand extends Command {
  int index;

  public DoneCommand(int index) {
    this.index = index;
  }
    /**
     * Marks a task as done by its index.
     * @param tasks Current list of tasks
     * @param ui UI being used
     * @param storage Current storage in use
     * @throws IOException Error with accessing file or file writer
     */
  @Override
  public void execute(TaskList tasks, Ui ui, Storage storage) throws IOException {
    Task task = tasks.getByIndex(index);
    task.setDone(true);
    ui.showDoneMessage(task);
  }
    /**
     * Tests if command is an Exit Command.
     * @return Whether command is Exit Command
     */
  @Override
  public boolean isExit() {
    return false;
  }
}
