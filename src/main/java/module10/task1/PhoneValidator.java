package module10.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator {
    private final BufferedReader reader;
    private final String regEx;
    private final StringBuilder output = new StringBuilder();

    public PhoneValidator(BufferedReader reader, String regEx) throws IOException {
        this.reader = reader;
        this.regEx = regEx;
        validated();
    }

    private void validated() throws IOException {
        Pattern pattern = Pattern.compile(regEx);
        String temp;
        while (reader.ready()){
            temp = reader.readLine();
            Matcher m = pattern.matcher(temp);
            if(m.find()){
                output.append(temp).append("\n");
            }
        }
    }

    public String getValidated() {
        return output.toString();
    }
}
