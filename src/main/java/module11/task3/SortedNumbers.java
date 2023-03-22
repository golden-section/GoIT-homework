package module11.task3;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortedNumbers {

    public static void main(String[] args) {

        String[] data = {"1, 2, 0", "4, 5", "6", " 7, 8", "9, 3  "};
        System.out.println(getSortedDigitsString(data));
    }
    public static String getSortedDigitsString(String[] array) {
        return Arrays
                .stream(array)
                .flatMap(string -> Stream.of(string.strip().split(", +")))
                .map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}