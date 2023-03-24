package module12.task2;

import java.util.function.IntConsumer;

public class FizzBuzzInThreads {
    private int number = 1;
    private final int endOfCounter;

    public FizzBuzzInThreads(int endOfCounter) {
        this.endOfCounter = endOfCounter;
    }

    public synchronized void fizzBuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (number <= endOfCounter) {
            if(number % 3 == 0 && number % 5 == 0) {
                printFizzBuzz.run();
                number++;
                notifyAll();
            } else
                wait();
        }
    }

    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while (number <= endOfCounter) {
            if(number % 3 == 0 && number % 5 != 0) {
                printFizz.run();
                number++;
                notifyAll();
            } else
                wait();
        }
    }

    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while (number <= endOfCounter) {
            if(number % 5 == 0 && number % 3 != 0) {
                printBuzz.run();
                number++;
                notifyAll();
            } else
                wait();
        }
    }

    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while (number <= endOfCounter) {
            if(number % 3 != 0 && number % 5 != 0) {
                printNumber.accept(number);
                number++;
                notifyAll();
            } else
                wait();
        }
    }
}
