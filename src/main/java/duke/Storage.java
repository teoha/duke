package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/** Deals with loading tasks from the file and saving tasks in the file. */
public class Storage {
    String filePath;
    File file;
    FileWriter fileWriter;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads tasks saved in an external file into the current list of tasks. Initializes a
     * FileWriter to write into external source.
     *
     * @return List of tasks loaded from external source
     * @throws IOException Thrown when there is a problem with loading the file
     * @throws ParseException Thrown when date provided by user is in the wrong format
     */
    public List<Task> load() throws IOException, ParseException {
        List<Task> tempTaskList = new ArrayList<>();
        file = new File(filePath);
        fileWriter = new FileWriter(filePath, true);
        Scanner fileScanner = new Scanner(file);

        while (fileScanner.hasNextLine()) {
            String info = fileScanner.nextLine();
            String[] infoArr = info.split(Pattern.quote("|"));
            Task newTask;
            if (infoArr[0].trim().equals("T")) {
                newTask = new ToDo(infoArr[2].trim());
                if (infoArr[1].trim().equals("1")) {
                    newTask.setDone(true);
                }
                tempTaskList.add(newTask);
            } else if (infoArr[0].trim().equals("D")) {
                newTask =
                        new Deadline(
                                infoArr[2].trim(),
                                new SimpleDateFormat("dd/MM/yyyy HHmm").parse(infoArr[3].trim()));
                if (infoArr[1].trim().equals("1")) {
                    newTask.setDone(true);
                }
                tempTaskList.add(newTask);
            } else if (infoArr[0].trim().equals("E")) {
                String startDate = infoArr[3].split("-")[0].trim();
                String endDate = infoArr[3].split("-")[1].trim();
                newTask =
                        new Event(
                                infoArr[2].trim(),
                                new SimpleDateFormat("dd/MM/yyyy HHmm").parse(startDate),
                                new SimpleDateFormat("dd/MM/yyyy HHmm").parse(endDate));
                if (infoArr[1].trim().equals("1")) {
                    newTask.setDone(true);
                }
                tempTaskList.add(newTask);
            }
        }

        return tempTaskList;
    }

    /**
     * Saves a to do task into the external file.
     *
     * @param description Description of the task
     * @throws IOException Thrown if there is an error writing into file
     */
    public void saveTodo(String description) throws IOException {
        if (fileWriter != null) {
            fileWriter.write(String.format("\nT | 0 | %s", description));
        }
    }

    /**
     * Saves a deadline task in to the external file.
     *
     * @param description Description of the task
     * @param date Date of deadline
     * @throws IOException Thrown if there is an error writing into file
     */
    public void saveDeadLine(String description, String date) throws IOException {
        if (fileWriter != null) {
            fileWriter.write(String.format("\nD | 0 | %s | %s", description, date));
        }
    }

    /**
     * Saves an event task into the external file.
     *
     * @param description Description of the task
     * @param duration Duration of the event detailing the start and end date
     * @throws IOException Thrown if there is an error writing into file
     */
    public void saveEvent(String description, String duration) throws IOException {
        if (fileWriter != null) {
            fileWriter.write(String.format("\nE | 0 | %s | %s", description, duration));
        }
    }

    /**
     * Closes the File Writer.
     *
     * @throws IOException Thrown if there is an error closing the File Writer
     */
    public void close() throws IOException {
        fileWriter.close();
    }
}
