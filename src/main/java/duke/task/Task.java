package duke.task;

/**
 * Parent class of all tasks. Tasks are identified by having a description and
 * its completion status.
 */
public class Task {
  protected String description;
  protected boolean isDone;

  public Task(String description) {
    this.description = description;
    this.isDone = false;
  }

    /**
     * Returns the description of the task.
     * @return a string describing the task.
     */
  public String getDescription() {
    return description;
  }

    /**
     * Sets the description of the task to the given input.
     * @param description User input of new description.
     */
  public void setDescription(String description) {
    this.description = description;
  }

    /**
     * Returns completion status of the task.
     * @return Returns true if task is completed.
     */
  public boolean isDone() {
    return isDone;
  }

    /**
     * Sets the completion status of the task.
     * @param done User input of new completion state.
     */
  public void setDone(boolean done) {
    isDone = done;
  }

    /**
     * Returns icon depicting completions status for the task.
     * @return return tick or X symbols
     */
  public String getStatusIcon() {
    return (isDone ? "\u2713" : "\u2718"); // return tick or X symbols
  }

    /**
     * Returns string representation of properties in the task.
     * @return string representation of task properties.
     */
  @Override
  public String toString() {
    return String.format("[%s] %s", getStatusIcon(), description);
  }
}
