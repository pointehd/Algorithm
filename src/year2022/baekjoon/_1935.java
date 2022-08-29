package year2022.baekjoon;

import java.util.Scanner;
import java.util.Stack;

/**
 * Baekjoon. 후위표기
 * https://www.acmicpc.net/problem/1935
 * <p>
 * Memory: 1,7816 KB
 * RunTime: 208 ms
 *
 * */
public class _1935 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int[] matchAlpha = new int[size];
        scanner.nextLine();
        String commandLine = scanner.nextLine();
        char[] commands = commandLine.toCharArray();

        for(int i=0; i<size; i++) {
            matchAlpha[i] = scanner.nextInt();
        }
        scanner.close();
        Stack<Double> stack = new Stack<>();
        for(char command : commands) {
            switch (command){
                case '+':
                case '-':
                case '/':
                case '*':
                    calculateOperator(command, stack);
                    break;
                default:
                    stack.push((double)matchAlpha[(int)command-65]);
                    break;
            }
        }
        System.out.printf("%.2f",stack.pop());
    }

    public static void calculateOperator(char operator, Stack<Double> stack) {
        double operand2 = stack.pop();
        double operand1 = stack.pop();
        double result = 0.0;
        switch (operator){
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '/':
                result = operand1 / operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
        }
        stack.push(result);
    }
}
