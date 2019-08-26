package duke.task;

/**
 * Represents a to do task
 */
public class ToDo extends Task {
  public ToDo(String description) {
    super(description);
  }

    /**
     * Returns a description of the properties of the task.
     * @return a string representation of the task.
     */
  @Override
  public String toString() {
    return String.format("[T]%s", super.toString());
  }
}
