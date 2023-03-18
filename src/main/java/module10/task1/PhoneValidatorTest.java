package module10.task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PhoneValidatorTest {
    public static void main(String[] args) {
        String phonePattern = "^((\\d{3})-(\\d{3})|(\\(\\d{3}\\)) (\\d{3}))-(\\d{4})$";
        File inputFile = new File("./files/file.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            PhoneValidator phoneNumbers = new PhoneValidator(reader, phonePattern);
            reader.close();
            System.out.println(phoneNumbers.getValidated());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
