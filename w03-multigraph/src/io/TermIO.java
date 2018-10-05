package io;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TermIO {

    private Scanner scan;
    private String prompt = "> ";

    public TermIO() {
        this.scan = new Scanner(System.in);
    }

    /**
     * Gets an int from standard in
     * Will keep prompting user with error message utill a valid int is entered
     *
     * @return an int
     */
    public int getInt() {
        int input = 1;
        boolean valid = false;

        while (!valid) {
            try {
                displayPrompt();
                input = scan.nextInt();
                valid = true;
            } catch (InputMismatchException ex) {
                System.out.println("Incorrect input. Please enter a valid number");
                valid = false;
                scan.nextLine();
            }
        }

        return input;
    }

    public String getString() {
        String input = "";
        boolean valid = false;

        while (!valid) {
            try {
                displayPrompt();
                input = scan.nextLine();
                valid = true;
            } catch (NoSuchElementException ex) {
                System.exit(0);
                System.out.println("No Input");
                valid = false;
            }
        }

        return input;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    private void displayPrompt() {
        System.out.print(prompt);
    }

    public void printSeparator() {
        for (int i = 0; i < 40; i++) {
            System.out.print("=");
        }
        System.out.println();
    }
}
