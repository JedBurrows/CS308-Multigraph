package io;

import java.util.*;

public class TermOptionMenu {

    private final TermIO termIO;
    private String title;
    private Map<String, String> options;
    private List<String> textInfo;
    private String description;

    public TermOptionMenu(String title) {
        this.title = title;
        options = new HashMap<>();
        textInfo = new ArrayList<>();
        termIO = new TermIO();
    }

    public void addText(String text) {
        textInfo.add(text);
    }

    /**
     * Enter option
     */
    public void addOption(String option, String keyboardCode) {
        options.put(option, keyboardCode.toUpperCase());
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets input from standard in. (Case insensitive)
     *
     * @return The command code in upper case
     */
    public String getStringInput() {
        String option;

        do {
            option = termIO.getString().toUpperCase();

            if (!(options.containsValue(option))) {
                System.out.println("Invalid option ");

                System.out.print("Available options: ");
                printAvailableOptions();

                System.out.println();
                print();
            }

        } while (!(options.containsValue(option)));

        return option;
    }

    private void printAvailableOptions() {
        for (String value : options.values()) {
            System.out.print(value + ", ");
        }
    }

    public int getIntInput() {
        int option;

        do {
            option = termIO.getInt();

            if (!(options.containsValue(String.valueOf(option)))) {
                System.out.println("Option is invalid");
            }

        } while (!(options.containsValue(String.valueOf(option))));

        return option;
    }

    public void print(boolean sort) {
        Map<String, String> map = options;

        if (sort) {
            map = new TreeMap<>(options);
        }

        printOptions(map);
    }

    public void print() {
        printOptions(options);
    }

    private void printOptions(Map<String, String> map) {
        System.out.println();
        System.out.println(title);

        termIO.printSeparator();
        if (description != null) System.out.println(description);


        for (String text : textInfo) {
            System.out.println(text);
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String command = entry.getValue();
            String optionName = entry.getKey();

            System.out.printf("[%s] %s \n", command.toUpperCase(), optionName);
        }
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
