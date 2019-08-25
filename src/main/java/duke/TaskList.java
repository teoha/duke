package duke;

import duke.task.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> taskList;

    public TaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
    public TaskList(){
        this.taskList = new ArrayList<>();
    }
    public void add(Task task){
        taskList.add(task);
    }
    public void delete(int inputNum){
        taskList.remove(inputNum-1);
    }

    public Task getByIndex(int index){
        return taskList.get(index);
    }
    public int listSize(){
        return taskList.size();
    }
}
