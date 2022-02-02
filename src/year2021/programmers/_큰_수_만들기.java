package year2021.programmers;

import java.util.Stack;

/**
 * Programmers. 큰 수 만들기
 * https://programmers.co.kr/learn/courses/30/lessons/42883
 *
 * 테스트 1 〉	통과 (0.25ms, 73.7MB)
 * 테스트 2 〉	통과 (0.25ms, 74.3MB)
 * 테스트 3 〉	통과 (0.33ms, 66.7MB)
 * 테스트 4 〉	통과 (2.91ms, 77MB)
 * 테스트 5 〉	통과 (1.23ms, 72.9MB)
 * 테스트 6 〉	통과 (5.92ms, 73.1MB)
 * 테스트 7 〉	통과 (14.60ms, 80.2MB)
 * 테스트 8 〉	통과 (17.78ms, 91.5MB)
 * 테스트 9 〉	통과 (32.12ms, 85.3MB)
 * 테스트 10 〉	통과 (51.94ms, 101MB)
 * 테스트 11 〉	통과 (0.18ms, 76.6MB)
 * 테스트 12 〉	통과 (0.21ms, 72.1MB)
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
