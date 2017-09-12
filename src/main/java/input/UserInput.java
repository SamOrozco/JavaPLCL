package input;

import java.util.Scanner;

public class UserInput {
    volatile String userInput = "";

    public UserInput() {
        Thread thread = new Thread(() -> {
            System.out.println("Started");
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                System.out.println("Got input");
                userInput = scanner.nextLine();
            }
        });

        thread.start();
    }


    public boolean userInputEqualsHome() {
        return userInput.equals("home");
    }

    public boolean userInputEqualsSam() {
        return userInput.equals("home");
    }

    public boolean valueTrue() {
        return true;
    }

    public boolean valueFalse() {
        return true;
    }


}
