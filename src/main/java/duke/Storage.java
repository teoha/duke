package duke;

import duke.exception.UnknownStorageEntryException;
import duke.task.Task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            try {
                tempTaskList.add(Parser.parseStorage(fileScanner.nextLine()));
            } catch (Exception e) {
                continue;
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
            fileWriter.close();
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
            fileWriter.close();
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
            fileWriter.close();
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
