package teaching.fiber;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;


@SuppressWarnings("all")
public class WithReactive {

    public void updateAllPrices(int discount) {


        Scheduler scheduler = Schedulers.newParallel("", 10);

        Flux.range(1, 100_1000)
                .map(productId -> retrieveProduct(productId))
                .map(product -> updatePrice(product))
                .flatMap(p -> {
                    return saveInDB(p);
                })
                .then();
    }

    private Product updatePrice(Product product) {
        return null;
    }

    private Mono<Void> saveInDB(Product p) {
        return null;
    }

    public Product retrieveProduct(int productId) {
        return null;
    }
}
