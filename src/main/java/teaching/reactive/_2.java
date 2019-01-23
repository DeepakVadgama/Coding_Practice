package teaching.reactive;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _2 {

    public static void main(String[] args) {


    }

    private void printDBValue() {

        ExecutorService service = Executors.newFixedThreadPool(5);
        service.submit(() -> {
            // fetch from DB
            return "fetched-value";
        });
    }
}
