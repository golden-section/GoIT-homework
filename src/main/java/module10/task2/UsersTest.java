package module10.task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UsersTest {
    public static void main(String[] args) {
        String inputFilePath = "./files/user.txt";
        String outputFilePath = "./files/user.json";
        File outputFile = new File(outputFilePath);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            Scanner scanner = new Scanner(new FileInputStream(inputFilePath));
            ArrayList<User> userData = CollectUsers.readData(scanner);
            Writer writer = new FileWriter(outputFile);
            gson.toJson(userData, writer);
            scanner.close();
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
