package year2022.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Programmers. 괄호 회전하기
 * https://programmers.co.kr/learn/courses/30/lessons/76502
 *
 * 테스트 1 〉	통과 (24.40ms, 91.1MB)
 * 테스트 2 〉	통과 (16.54ms, 78.1MB)
 * 테스트 3 〉	통과 (15.91ms, 78.7MB)
 * 테스트 4 〉	통과 (16.77ms, 80.7MB)
 * 테스트 5 〉	통과 (27.16ms, 74.6MB)
 * 테스트 6 〉	통과 (20.65ms, 80.8MB)
 * 테스트 7 〉	통과 (24.40ms, 80.2MB)
 * 테스트 8 〉	통과 (30.34ms, 76.4MB)
 * 테스트 9 〉	통과 (30.65ms, 85MB)
 * 테스트 10 〉	통과 (37.49ms, 91MB)
 * 테스트 11 〉	통과 (45.58ms, 87.4MB)
 * 테스트 12 〉	통과 (1.95ms, 74.5MB)
 * 테스트 13 〉	통과 (1.68ms, 75.6MB)
 * 테스트 14 〉	통과 (1.68ms, 88.3MB)
 */
public class _괄호_회전하기 {
    public int solution(String s) {
        int answer = 0;
        List<String> list = Arrays.stream(s.split("")).collect(Collectors.toList());

        match(list);
        list.stream().forEach(System.out::println);
        for(int i=0; i < s.length(); i++){
            String tmp = list.get(0);
            list.remove(0);
            list.add(tmp);
            if(match(list)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean match(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (String s : list) {
            switch (s) {
                case "}":
                    if (stack.size() > 0 && stack.peek().equals("{")) {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case ")":
                    if (stack.size() > 0 && stack.peek().equals("(")) {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case "]":
                    if (stack.size() > 0 && stack.peek().equals("[")) {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                default:
                        stack.add(s);
            }
        }
        if(stack.size() > 0) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String str = "[](){}";
        System.out.println(new _괄호_회전하기().solution(str));
    }
}
