package teaching.parallelism;

public class ConcurrencyExample {

    private static int ticketsAvailable = 2;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            if (ticketsAvailable > 0) {
                bookTicket();
                ticketsAvailable--;
            }
        }).start();

        new Thread(() -> {
            if (ticketsAvailable > 0) {
                bookTicket();
                ticketsAvailable--;
            }
        }).start();

        Thread.sleep(5000);
    }

    private static void bookTicket() {

    }
}
