package module11.task5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class MixStreamElements {
    public static void main(String[] args) {

        Stream<String> firstStream = Stream.of("One", "Two", "Three", "Four", "Five", "Six");
        Stream<String> secondStream = Stream.of("1", "2", "3", "4", "5", "6", "7");

        System.out.println(zip(firstStream, secondStream).toList());

    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {

        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();
        List<T> output = new ArrayList<>();

        while (firstIterator.hasNext() && secondIterator.hasNext()) {
            output.add(firstIterator.next());
            output.add(secondIterator.next());
        }
        return output.stream();
    }
}