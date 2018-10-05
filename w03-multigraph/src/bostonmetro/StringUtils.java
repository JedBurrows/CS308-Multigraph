package bostonmetro;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {

    /**
     * Removes whitespace and characters from a string
     * '.', ' ', ',', ';', '\'', '\n', '\t'
     *
     * @param str
     * @return
     */
    public String stripCharacters(String str) {

        str = str.toLowerCase();

        List<Character> listToRemove = new ArrayList<Character>() {{
            add('.');
            add(' ');
            add(',');
            add(';');
            add('\'');
            add('\n');
            add('\t');
        }};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {

            if (!listToRemove.contains(str.charAt(i))) {
                sb.append(str.charAt(i));
            }

        }

        return sb.toString();
    }

    /**
     * Adds space to upper camel case text after each word
     *
     * @param str
     * @return
     */
    public String formatText(String str) {

        StringBuilder sb = new StringBuilder();

        if (str.length() <= 1) return str;

        str = str.trim();
        for (int i = 0; i < str.length(); i++) {

            sb.append(str.charAt(i));

            if (i < str.length() - 2 && str.substring(i + 1, i + 2).matches("[A-Z]") &&
                    !str.substring(i + 2, i + 3).matches("[A-Z]")) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
