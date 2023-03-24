package module12.task1;

public class TimerAndBeeper {
    public static void main(String[] args) {

        timer().start();
        everyFiveSecondsBeeper().start();
    
    }

    public static Thread timer (){
        return new Thread(() -> {
            long programStartTime = System.currentTimeMillis();
            long timeInSeconds;
            while (true){
                try {
                    Thread.sleep(1000L);
                    timeInSeconds = (System.currentTimeMillis() - programStartTime) / 1000;
                    if(timeInSeconds % 5 == 0) {
                        Thread.onSpinWait();
                    } else System.out.println(timeInSeconds + " sec - " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "Timer thread");
    }

    public static Thread everyFiveSecondsBeeper (){
        return new Thread(() -> {
            long programStartTime = System.currentTimeMillis();
            long timeInSeconds;
            while (true){
                try {
                    Thread.sleep(5000L);
                    timeInSeconds = (System.currentTimeMillis() - programStartTime) / 1000;
                    System.out.println(timeInSeconds + " - 5 seconds have passed - " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "Beeper thread");
    }
}
