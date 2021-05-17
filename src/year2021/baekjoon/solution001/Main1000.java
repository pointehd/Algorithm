package year2021.baekjoon.solution001;

import java.util.Scanner;

public class Main1000 {
    static CustomMath math = (num1, num2)-> num1+num2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(math.sum(a, b));
    }
    /**
     * 21. 05. 17 : FunctionalInterface  아직왜쓰는지 잘모르겠당~
     * */
    @FunctionalInterface
    interface CustomMath {
        public int sum(int a, int b);
    }
}
