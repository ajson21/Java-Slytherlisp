package types;

import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public Vector Parsestr (String line) {
        String pattern = "(\\()|(\\))|(\\')|(^\\#\\![^\\n]*\\n)|(\"(?:[^\"\\\\]|\\\\.)*\")|(;.*)|(-?\\.?\\d+\\.?\\d*)|([^.\\'\\s\\\"\\(\\);][^\\'\\s\\\"\\(\\);]*)|(\\s)|(.)";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        Vector parsed = new Vector();
        // Now create matcher object.
        Matcher m = r.matcher(line);
        while (m.find( )) {
            String s = new String();
            s = m.group();
            boolean isWhitespace = s.matches("^\\s*$");
            if (!isWhitespace) {
                parsed.add(m.group());
            }
        }
        return parsed;
    }
}
