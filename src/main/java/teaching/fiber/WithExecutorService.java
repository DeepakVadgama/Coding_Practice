package teaching.fiber;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WithExecutorService {

    public void updateAllPrices(int discount) {

        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100_000; i++) {

            int productId = i;
            Runnable task = new Runnable() {

                @Override
                public void run() {
                    Product p = retrieveProduct(productId);
                    updatePrice(p);
                    saveInDB(p);
                }
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
