package year2022.book.modernjavainaction._16;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class _16 {
    static Shop shop = new Shop();

    public static void main(String[] args) {
        long start = System.nanoTime();
        test16_2();
        long end = System.nanoTime();
        System.out.println("실행시간 : " + (end-start) /1_000_000);
    }

    public static void test16_2() {
        Future<Double> test1 = shop.getPriceAsync("test1");
        Future<Double> test2 = shop.getPriceAsync("test2");
        Future<Double> test3 = shop.getPriceAsync("test3");
        // 추가 작업 가능 메인 스레드
        System.out.println(shop.getPrice("test4"));
        try {
            System.out.println(test1.get());
            System.out.println(test2.get());
            System.out.println(test3.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void test16_1() {
        System.out.println(shop.getPrice("test1"));
        System.out.println(shop.getPrice("test2"));
        System.out.println(shop.getPrice("test3"));
    }

}
