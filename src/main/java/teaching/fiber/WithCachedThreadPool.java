package teaching.fiber;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings("all")
public class WithCachedThreadPool {

    public void updateAllPrices(int discount) {

        ExecutorService threadPool = Executors.newCachedThreadPool();

        for (int i = 0; i < 100_000; i++) {

            int productId = i;
            Runnable task = () -> {
                Product p = retrieveProduct(productId);
                updatePrice(p);
                saveInDB(p);
            };
            threadPool.submit(task);
        }
    }

    private void updatePrice(Product p) {
    }


    private void saveInDB(Product p) {

    }

    public Product retrieveProduct(int productId) {
        return null;
    }
}
