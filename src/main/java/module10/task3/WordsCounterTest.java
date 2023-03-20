package module10.task3;

import java.util.ArrayList;

public class WordsCounterTest {
    public static void main(String[] args) {
        String inputFilePath = "./files/words.txt";
        ArrayList<Word> test = CollectWords.readData(inputFilePath);

        WordQuantityComparator comparator = new WordQuantityComparator();
        test.sort(comparator);

        for (Word word: test) {
            System.out.println(word);
        }
    }
}
