package duke;

import duke.task.Task;
import java.util.Scanner;

public class Ui {
  private Scanner scanner;

  public Ui() {
    this.scanner = new Scanner(System.in);
  }

  public void showError(String errorMessage) {
    System.out.println(errorMessage);
  }

  public void showClosingMessage() {
    System.out.println("Bye. Hope to see you again soon!");
  }

  public void showListElement(Task task, int index) {
    System.out.println((index + 1) + ". " + task);
  }

  public void showListHeader() {
    System.out.println("Here are the tasks in your list:");
  }

  public void showDoneMessage(Task task) {
    System.out.println("Nice! I've marked this task as done: \n" + task);
  }

  public void showTaskAddedMessage(Task task, TaskList tasks) {
    System.out.println("Got it. I've added this task: \n" + task);
    System.out.println(String.format("Now you have %d tasks in the list.", tasks.listSize()));
  }

  public void showDeleteMessage(Task task, TaskList tasks) {
    System.out.println(
        "Noted. I've removed this task: \n"
            + task
            + "\nNow you have "
            + tasks.listSize()
            + " tasks in the list.");
  }

  public void showWelcome() {
    System.out.println("Hello! I'm duke.Duke\nWhat can I do for you?");
  }

  public void showLine() {
    System.out.println();
  }

  public void showLoadingError() {
    System.out.println("Cannot load file");
  }

  public String readCommand() {
    return scanner.nextLine();
  }
}
