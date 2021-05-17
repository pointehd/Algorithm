package year2021.baekjoon.solution001;

import java.util.Scanner;

public class Main1001 {

    /**
     * Memory : 1,8389 KB
     * Run Time : 268 ms
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(CustomMath.calculate(a, b, (i, j) ->i-j));
    }

    @FunctionalInterface
    interface CustomOperator {
        public int operate(int a, int b);
    }
    static class CustomMath {
        public static int calculate(int a, int b, CustomOperator operator){
            return operator.operate(a, b);
        }
    }
}
