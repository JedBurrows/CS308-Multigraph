import bostonmetro.BadFileException;
import bostonmetro.BostonMetro;
import bostonmetro.BostonMetroTerm;
import bostonmetro.MetroMapParser;
import graph.IMultigraph;
import io.Term;

import java.io.IOException;

public class Driver {

    public static void main(String[] args) throws IOException {

        MetroMapParser metroMapParser = new MetroMapParser("bostonmetro.txt");
        IMultigraph mg = null;
        try {
            mg = metroMapParser.generateGraphFromFile();

        } catch (BadFileException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        BostonMetro bostonMetro = new BostonMetro(mg);

        Term term = new BostonMetroTerm(bostonMetro);
        term.start();
    }
}