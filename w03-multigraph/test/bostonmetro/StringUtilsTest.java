package bostonmetro;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilsTest {

    private StringUtils strUtils;

    @Before
    public void setup() {
        strUtils = new StringUtils();
    }

    @Test
    public void stripCharacters() throws Exception {
        String name = "St Paul Street";
        assertEquals("stpaulstreet", strUtils.stripCharacters(name));
    }

    @Test
    public void stripCharacters2() throws Exception {
        String name = "St.PaulStreet";
        assertEquals("stpaulstreet", strUtils.stripCharacters(name));
    }


    @Test
    public void formatText() throws Exception {
        String name = "StPaulStreet";
        assertEquals("St Paul Street", strUtils.formatText(name));
    }

    @Test
    public void formatText2() throws Exception {
        String name = "Hynes/ICA";
        assertEquals("Hynes/ICA", strUtils.formatText(name));
    }

    @Test
    public void formatText3() throws Exception {
        String name = "ABC";
        assertEquals("ABC", strUtils.formatText(name));
    }

    @Test
    public void formatText4() throws Exception {
        String name = "DowntownCrossing";
        assertEquals("Downtown Crossing", strUtils.formatText(name));
    }
}