package module11.task1;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OddEntries {
    public static String getOddEntries(List<String> names) {
        return IntStream.range(0, names.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> i + ". " + names.get(i))
                .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Mike", "Ivan", "Alex", "Robert", "Bob", "Jane", "Polly");
        System.out.println(getOddEntries(names));
    }
}