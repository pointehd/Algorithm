package year2022.baekjoon;

import java.util.Scanner;
import java.util.Stack;

/**
 * Baekjoon. 스택_수열
 * https://www.acmicpc.net/problem/1874
 * <p>
 * Memory: 11,1112 KB
 * RunTime: 1036 ms
 */
public class _1874 {

    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> stack = new Stack<>();
    static int number = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        for (int i = 1; i <= count; i++) {
            int number = scanner.nextInt();
            if(method(number)){
                break;
            }
        }
        System.out.print(!stack.isEmpty() ? "NO" : sb.toString());
    }

    public static boolean method(int num) {
        if (stack.isEmpty() || stack.peek() < num){
            for(int i = number; i <= num; i++){
                stack.push(i);
                sb.append("+\n");
            }
            number = num+1;
        }
        if(!stack.isEmpty() && stack.peek() == num){
            stack.pop();
            sb.append("-\n");
        } else {
            return true;
        }
        return false;

    }
}
