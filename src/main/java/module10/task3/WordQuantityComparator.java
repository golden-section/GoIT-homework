package module10.task3;

import java.util.Comparator;

public class WordQuantityComparator implements Comparator<Word> {
        @Override
        public int compare(Word word1, Word word2) {
            return Integer.compare(word2.getQuantity(), word1.getQuantity());
        }
}

