package duke.util;

import duke.task.Task;
import java.util.ArrayList;
import java.util.List;

/** Contains the task list and operations to manage tasks in the list. */
public class TaskList {

    private List<Task> taskList;

    public TaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    /**
     * Add a task into the list.
     *
     * @param task Task to be added into the list.
     */
    public void add(Task task) {
        taskList.add(task);
    }

    /**
     * Remove a task from the list using its index as displayed.
     *
     * @param inputNum Index of item to remove as displayed to user.
     */
    public void delete(int inputNum) {
        taskList.remove(inputNum - 1);
    }

    /**
     * Returns a task from the task list by its index (starting from 0).
     *
     * @param index Index of item in the list
     * @return Task denoted by index.
     */
    public Task getByIndex(int index) {
        return taskList.get(index);
    }

    /**
     * Returns number of tasks in the list.
     *
     * @return Integer of total number of tasks in the list.
     */
    public int listSize() {
        return taskList.size();
    }
}
