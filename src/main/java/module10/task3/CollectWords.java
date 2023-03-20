package module10.task3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CollectWords {
    public static ArrayList<Word> readData(String inputFilePath) {
        ArrayList<String> rawData = new ArrayList<>();
        ArrayList<Word> result = new ArrayList<>();
        String pattern = "[^a-zA-Z]+";

        try {
            Scanner scanner = new Scanner(new FileInputStream(inputFilePath)).useDelimiter(pattern);
            while (scanner.hasNext()){
                rawData.add(scanner.next());
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        String[] array = rawData.toArray(new String[0]);

        int wordCounter = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[i].equals(array[j])) {
                    wordCounter++;
                    array[j] = "0";
                }
            }
            if(!array[i].equals("0")) {
                Word word = new Word(array[i], wordCounter);
                result.add(word);
            }
            wordCounter = 1;
        }
        return result;
    }
}
