package module11.task2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UpperCasedEntries {
    public static List<String> getUpperCased(List<String> names) {
        return names.stream()
                .map(String::toUpperCase)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Mike", "Ivan", "Alex", "Robert", "Bob", "Jane", "Polly");
        System.out.println(getUpperCased(names));
    }
}
