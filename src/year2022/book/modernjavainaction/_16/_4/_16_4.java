package year2022.book.modernjavainaction._16._4;

import year2022.book.modernjavainaction._16.Discount;
import year2022.book.modernjavainaction._16.Quote;
import year2022.book.modernjavainaction._16.Shop;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _16_4 {
    static Shop shop = new Shop();
    static List<String> products = List.of("Test1", "A2", "B3");
    static Executor executor = Executors.newFixedThreadPool(Math.min(products.size(), 100), // products.size() 만큼 생성
            new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    Thread thread = new Thread(r);
                    thread.setDaemon(true);
                    return thread;
                }
            });

    public static void main(String[] args) {
        long start = System.nanoTime();
        CompletableFuture[]  futures = findPricesStream().map(f -> f.thenAccept(System.out::println))
            .toArray(size-> new CompletableFuture[size]);
        CompletableFuture.anyOf(futures).join();
        long end = System.nanoTime();
        System.out.println("실행시간 : " + (end-start) /1_000_000);
    }

    public static Stream<CompletableFuture<String>> findPricesStream() {
        return products.stream()
                .map(product -> CompletableFuture.supplyAsync(
                        () -> shop.getPrice2(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote ->
                        CompletableFuture.supplyAsync(
                                () -> Discount.applyDiscount(quote), executor)));
    }


    public static List<String> findPrices2() {
        List<CompletableFuture<String>> priceFutures =
                products.stream()
                        .map(product -> CompletableFuture.supplyAsync(
                                () -> shop.getPrice2(product), executor))// (1)
                        .map(future -> future.thenApply(Quote::parse))// (2)
                        .map(future -> future.thenCompose(quote -> // (3)
                                CompletableFuture.supplyAsync(
                                        () -> Discount.applyDiscount(quote), executor)))
                        .collect(Collectors.toList());
        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public static List<String> findPrices() {
        return products.stream()
            .map(product -> shop.getPrice2(product))
            .map(Quote::parse)
            .map(Discount::applyDiscount)
            .collect(Collectors.toList());
    }

}
