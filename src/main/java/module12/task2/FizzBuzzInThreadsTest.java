package module12.task2;

import java.util.function.IntConsumer;

public class FizzBuzzInThreadsTest {
    public static void main(String[] args) {

        FizzBuzzInThreads test = new FizzBuzzInThreads(37);

        Runnable fizzBuzz = () -> System.out.println("FizzBuzz - " + Thread.currentThread().getName());
        Runnable fizz = () -> System.out.println("Fizz - " + Thread.currentThread().getName());
        Runnable buzz = () -> System.out.println("Buzz - " + Thread.currentThread().getName());
        IntConsumer number = (num) -> System.out.println(num + " - " + Thread.currentThread().getName());

        Thread threadA = new Thread(() -> {
            try {
                test.fizz(fizz);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Thread A");

        Thread threadB = new Thread(() -> {
            try {
                test.buzz(buzz);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Thread B");

        Thread threadC = new Thread(() -> {
            try {
                test.fizzBuzz(fizzBuzz);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Thread C");

        Thread threadD = new Thread(() -> {
            try {
                test.number(number);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Thread D");

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }
}