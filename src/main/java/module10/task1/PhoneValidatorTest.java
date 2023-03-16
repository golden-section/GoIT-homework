package module10.task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PhoneValidatorTest {
    public static void main(String[] args) throws IOException {
        String phonePattern = "^((\\d{3})-(\\d{3})|(\\(\\d{3}\\)) (\\d{3}))-(\\d{4})$";
        File inputFile = new File("file.txt");
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        PhoneValidator phoneNumbers = new PhoneValidator(reader, phonePattern);
        System.out.println(phoneNumbers.getValidated());
    }
}
