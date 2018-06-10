package teaching.reactive;

import java.util.concurrent.CompletableFuture;

public class _5 {

    public static void main(String[] args) {

    }

    private void printDBValue() {

        CompletableFuture.supplyAsync(() -> {
            // fetch from DB
            return "fetched-value";
        }).thenRunAsync(System.out::println);
    }
}
