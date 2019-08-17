import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String s = scanner.next();
            switch (s){
                case("bye"):
                    System.out.println("Bye. Hope to see you again soon!");
                    System.exit(0);
                default:
                    System.out.println(s);
            }
        }
    }
}
