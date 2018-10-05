package bostonmetro;

import graph.IEdge;
import graph.IMultigraph;
import graph.INode;
import graph.Node;

import java.util.*;
import java.util.stream.Collectors;

public class BostonMetro {
    private final StringUtils stringUtils;
    private IMultigraph mg;

    public BostonMetro(IMultigraph mg) {
        this.mg = mg;
        stringUtils = new StringUtils();
    }

    // method changed to display results to the console
    public void getDirections(INode stationOrigin, INode stationDestination) {
        List<IEdge> path = mg.findPath(stationOrigin, stationDestination);

        // directions to the same station
        if (path == null) {
            System.out.println("Your start and end stations are the same");
            return;
        }

        String lineColour = path.get(0).getLabel();
        IEdge originLine = path.get(0);

        String originLineFinishName = originLine.getFinish().getName();
        String originStationName = stationOrigin.getName();

        // Text formatting
        lineColour = stringUtils.formatText(lineColour);
        originStationName = stringUtils.formatText(originStationName);
        originLineFinishName = stringUtils.formatText(originLineFinishName);


        System.out.println("O Take a " + lineColour + " line train at " + originStationName +
                " station towards " + originLineFinishName + " station");

        for (IEdge line : path) {
            String startLineName = line.getStart().getName();
            String endLineName = line.getFinish().getName();

            // Formatting
            startLineName = stringUtils.formatText(startLineName);
            endLineName = stringUtils.formatText(endLineName);

            if (!lineColour.equals(line.getLabel())) {
                lineColour = line.getLabel();
                System.out.println("O Switch to line " + lineColour + " at " +
                        startLineName + " station towards " + endLineName);
            }

            System.out.println("|\t" + endLineName + " station");

            if (line.getFinish().equals(stationDestination)) {
                System.out.println("O Arrive at destination " + endLineName + " station");
                break;
            }
        }
    }

    public List<INode> findStationByName(String input) {
        List<INode> stations = new ArrayList<>();

        StringUtils su = new StringUtils();
        input = su.stripCharacters(input.toLowerCase()).trim();
        
        System.out.println(input);

        for (INode currentStation : mg.getNodes()) {
            String stationName = su.stripCharacters(currentStation.getName());

            if (stationName.equals(input)) {
                stations.add(currentStation);
            }
        }
        
        System.out.println("No of nodes: " + mg.getNodes().size());

        return stations;
    }


    public INode getStationById(int id) {
        return mg.findNodeById(id);
    }

    /**
     * @return Returns list of stations sorted in alphabetical order
     */
    public List<String> getStations() {
        List<INode> sortedStations = new ArrayList<>(mg.getNodes());

        // Sort stations into alphabetical order
        sortedStations = sortedStations.stream()
                .sorted(Comparator.comparing(INode::getName))
                .collect(Collectors.toList());

        
        List<String> stationNames = new ArrayList<>();
        
        // Format station names
        sortedStations
                .forEach(station -> {
                	String formattedName = stringUtils.formatText(station.getName());
                	stationNames.add(formattedName);
                	}
              );
                
                
        return stationNames;
    }

    /**
     * @return a list of station lines
     */
    public List<String> getLines() {
        List<String> sortedLines = new ArrayList<>();

        mg.getEdgesLabels()
                .forEach(lineName -> sortedLines.add(stringUtils.formatText(lineName)));
        Collections.sort(sortedLines);

        return sortedLines;
    }
}
