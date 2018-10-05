package bostonmetro;

import graph.IMultigraph;
import org.junit.Before;
import org.junit.Test;

public class BostonMetroTest {
    private BostonMetro bostonMetro;

    @Before
    public void setUp() throws Exception {
        MetroMapParser metroMapParser = new MetroMapParser("bostonmetro.txt");
        IMultigraph mg = null;
        try {
            mg = metroMapParser.generateGraphFromFile();

        } catch (BadFileException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        bostonMetro = new BostonMetro(mg);
    }

    @Test
    public void getDirections() throws Exception {
    }

    @Test
    public void getStations() throws Exception {
    }

    @Test
    public void getNode() throws Exception {
    }

    @Test
    public void getStations1() throws Exception {
    }

    @Test
    public void getLines() throws Exception {
        System.out.println(bostonMetro.getLines());
    }

    @Test
    public void printMetroSystem() throws Exception {
    }

}