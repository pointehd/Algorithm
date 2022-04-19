package year2022.book.modernjavainaction._16;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {
    static Random random = new Random();

    Future<Double> getPriceAsyncLambda(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    Future<Double> getPriceAsyncError(String product) {
        CompletableFuture<Double> result = new CompletableFuture<>();
        new Thread(() -> {
            try {
                // calculatePrice가 api 호출이라면 TimeoutException 등 여러 Exception이 발생할수 있다.
                double price = calculatePrice(product);
                result.complete(price);
            } catch (Exception e) {
                result.completeExceptionally(e);
            }
        }).start();
        return result;
    }

    Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> result = new CompletableFuture<>();
        new Thread(() -> {
            double price = calculatePrice(product);
            result.complete(price);
        }).start();
        return result;
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }
    public String getPrice2(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", product, price, code);
    }


    // 인위적 딜레이로 api 호출 또는 시간이 오래걸리는 작업으로 볼것.
    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) - product.charAt(1);
    }

    private static void delay() {
        try {
            int delay = 500 + random.nextInt(2000);
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
/**
 *

 public static void delay(long n) {
 try {
 Thread.sleep(1000 * n);
 } catch (InterruptedException e) {
 e.printStackTrace();
 }
 }
 * */
