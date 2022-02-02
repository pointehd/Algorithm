package year2021.programmers;

import java.util.Stack;

/**
 * Programmers. 큰 수 만들기
 * https://programmers.co.kr/learn/courses/30/lessons/42883
 * */
class _큰_수_만들기 {
    public String solution(String numbers, int k) {
        char[] result = new char[numbers.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<numbers.length(); i++) {
            char c = numbers.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k > 0) {
                k--;
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}
