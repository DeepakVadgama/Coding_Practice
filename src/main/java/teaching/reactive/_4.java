package teaching.reactive;

import java.util.concurrent.CompletableFuture;

public class _4 {

    public static void main(String[] args) {

        CompletableFuture.supplyAsync(() -> {
            // fetch from DB
            return "fetched-value";
        }).thenRunAsync(System.out::println);
    }
}
