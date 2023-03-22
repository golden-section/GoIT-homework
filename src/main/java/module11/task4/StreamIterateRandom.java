package module11.task4;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class StreamIterateRandom {

    public static Stream<Long> randomizer(long a, long c, long m) {
        long timestamp = new Date().getTime();
        return Stream.iterate(timestamp, (x) -> (a * x + c) % m);
    }

    public static void main(String[] args) {

        long a = 25214903917L;
        long c = 11L;
        long m = (long) Math.pow(2, 48);

        List<Long> randValues = randomizer(a, c, m)
                .limit(10)
                .toList();

        System.out.println(randValues);
    }
}
