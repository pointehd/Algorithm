package year2022.book.modernjavainaction._16._3;

import year2022.book.modernjavainaction._16.Shop;

import java.awt.*;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class _16_2 {
    static Shop shop = new Shop();
    static List<String> products = List.of("Test1", "A2", "B3", "C4", "맥북", "아이패드", "펜슬");
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

        findPriceFuture2().stream()
                .forEach(System.out::println);
        long end = System.nanoTime();

        System.out.println("실행시간 : " + (end-start) /1_000_000);
    }

    public static List<String> findPriceFuture2() {
        List<CompletableFuture<String>> futures = products.stream()
                .map(products ->
                        CompletableFuture.supplyAsync(() ->
                                String.format("%s price is %.2f", products, shop.getPrice(products)), executor)) // 여기만 바뀜 스레드풀 지정
                .collect(Collectors.toList());
        return futures.stream()
                .map(CompletableFuture::join) // 함수 호출 방법
                .collect(Collectors.toList());
    }

    public static List<String> findPriceFuture() {
        List<CompletableFuture<String>> futures = products.stream()
                .map(products ->
                        CompletableFuture.supplyAsync(() ->
                            String.format("%s price is %.2f", products, shop.getPrice(products))))
                .collect(Collectors.toList());
        return futures.stream()
                .map(future -> future.join()) // join 은 get() 과 같은 의미를 가진다.
                .collect(Collectors.toList());
    }

    public static List<String> findPriceParallel() {
        return products.parallelStream()
                .map(product -> String.format("%s price is  %.2f", product, shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    public static List<String> findPrice() {
        return products.stream()
                .map(product -> String.format("%s price is  %.2f", product, shop.getPrice(product)))
                .collect(Collectors.toList());
    }
}
