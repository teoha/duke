package duke;

import duke.task.Task;
import java.util.Scanner;

/** Provides methods to deal with all interactions with the user. */
public class Ui {
    private Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Prints the message of an error.
     *
     * @param errorMessage Message of an error
     */
    public void showError(String errorMessage) {
        System.out.println(errorMessage);
    }

    /** Prints the message when the user terminates the operation. */
    public void showClosingMessage() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    /**
     * Prints an element in the list displayed to the user.
     *
     * @param task Task being processed
     * @param index Index of the task being processed
     */
    public void showListElement(Task task, int index) {
        System.out.println((index + 1) + ". " + task);
    }

    /** Prints the header of the list when requested by user. */
    public void showListHeader() {
        System.out.println("Here are the tasks in your list:");
    }

    /**
     * Prints the message shown after a task is marked as done.
     *
     * @param task Task being marked as done.
     */
    public void showDoneMessage(Task task) {
        System.out.println("Nice! I've marked this task as done: \n" + task);
    }

    /**
     * Prints message about the task and the size of task list after a task is added into the list.
     *
     * @param task Task being added to the list.
     * @param tasks List of tasks.
     */
    public void showTaskAddedMessage(Task task, TaskList tasks) {
        System.out.println("Got it. I've added this task: \n" + task);
        System.out.println(String.format("Now you have %d tasks in the list.", tasks.listSize()));
    }

    /**
     * Prints message after a task is deleted.
     *
     * @param task Task being deleted
     * @param tasks List of tasks task is being deleted from.
     */
    public void showDeleteMessage(Task task, TaskList tasks) {
        System.out.println(
                "Noted. I've removed this task: \n"
                        + task
                        + "\nNow you have "
                        + tasks.listSize()
                        + " tasks in the list.");
    }

    /** Prints the welcome message when the application first starts up. */
    public void showWelcome() {
        System.out.println("Hello! I'm duke.Duke\nWhat can I do for you?");
    }

    /** Prints an empty line. */
    public void showLine() {
        System.out.println();
    }

    /** Prints the error message when file containing saved tasks cannot be loaded. */
    public void showLoadingError() {
        System.out.println("Cannot load file");
    }

    /** Prints message header for list in list of relevant results. */
    public void showFindMessage() {
        System.out.println("Here are the matching tasks in your list:");
    }

    /**
     * Reads the command in the next line a user inputs.
     *
     * @return String representation of the command in the next line.
     */
    public String readCommand() {
        return scanner.nextLine();
    }
}
