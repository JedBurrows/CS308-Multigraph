package bostonmetro;

import graph.INode;
import io.Term;
import io.TermIO;
import io.TermOptionMenu;

import java.util.*;

public class BostonMetroTerm implements Term {

    private final BostonMetro bostonMetro;
    private static final String TRAVEL = "T";
    private static final String STATIONS = "S";
    private static final String EXIT = "E";
    private TermIO input;

    public BostonMetroTerm(BostonMetro bostonMetro) {
        this.bostonMetro = bostonMetro;
        input = new TermIO();
    }

    public void start() {

        TermOptionMenu startMenu = new TermOptionMenu("Welcome to Boston Metro");
        startMenu.setDescription("What would you like to do?");
        startMenu.addOption("Travel", TRAVEL);
        startMenu.addOption("List Stations", STATIONS);
        startMenu.addOption("Exit", EXIT);

        while (true) {
            startMenu.print();

            String option = startMenu.getStringInput();
            System.out.println(option);

            switch (option) {
                case TRAVEL:
                    travelMenu();
                    break;
                case STATIONS:
                    stationMenu();
                    break;
                case EXIT:
                    System.out.println("Bye");
                    System.exit(0);
                    break;
            }

        }

    }

    private void stationMenu() {
        TermOptionMenu stationMenu = new TermOptionMenu("Stations ");

        for (String currentStation : bostonMetro.getStations()) {
            stationMenu.addText(currentStation);
        }

        stationMenu.print();
    }

    private void travelMenu() {

        TermOptionMenu travelMenu = new TermOptionMenu("Travel ");
        travelMenu.print();

        System.out.println("Enter station: ");
        INode origin = getStationInput();

        System.out.println("Enter destination: ");
        INode destination = getStationInput();
        /*
        
        if(origin.getName().equals("St.PaulStreet")) {
        	origin = getSpecialCase();
        }
        
        if(destination.getName().equals("St.PaulStreet")) {
        	destination = getSpecialCase();
        }
        */

        bostonMetro.getDirections(origin, destination);
    }

    private INode getStationInput() {
        INode station = null;

        List<INode> stationsList;

        do {
            stationsList = bostonMetro.findStationByName(input.getString());

            if (stationsList == null || stationsList.size() == 0) {
                System.out.println("Station not found");
            }

        } while (stationsList == null || stationsList.size() == 0);
        
        

        if (stationsList.size() == 1) {
            station = stationsList.get(0);

        } else if ((stationsList.size() >= 2)){
            station = getSpecialCase();
        }

        System.out.println(station.getName() + " Station selected");
        return station;
    }

    private INode getSpecialCase() {

        // Special case of St Paul Street
        TermOptionMenu specialCaseMenu = new TermOptionMenu("Duplicate found");
        specialCaseMenu.setDescription("Which St. Paul Street do you mean?");
        specialCaseMenu.addOption("St. Paul Street - Green B", "1");
        specialCaseMenu.addOption("St. Paul Street - Green C", "2");
        specialCaseMenu.print(true);

        String option = specialCaseMenu.getStringInput();
        System.out.println(option);

        INode station;

        switch (option) {
            case "1":
                station = bostonMetro.getStationById(38);
                break;
            case "2":
                station = bostonMetro.getStationById(61);
                break;
            default:
                station = null;
                break;
        }


        return station;
    }
}
