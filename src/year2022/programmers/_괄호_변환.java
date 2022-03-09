package year2022.programmers;

import java.util.Arrays;
import java.util.Stack;

/**
 * Programmers. 괄호 변환
 * https://programmers.co.kr/learn/courses/30/lessons/60058
 * 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
 * 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
 * 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
 * 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
 * 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
 * 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
 * 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
 * 4-3. ')'를 다시 붙입니다.
 * 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
 * 4-5. 생성된 문자열을 반환합니다.
 *
 * 테스트 1 〉	통과 (3.75ms, 75.1MB)
 * 테스트 2 〉	통과 (2.14ms, 78.6MB)
 * 테스트 3 〉	통과 (2.70ms, 73.4MB)
 * 테스트 4 〉	통과 (2.84ms, 75.4MB)
 * 테스트 5 〉	통과 (3.07ms, 75.3MB)
 * 테스트 6 〉	통과 (3.17ms, 78.4MB)
 * 테스트 7 〉	통과 (2.86ms, 73.8MB)
 * 테스트 8 〉	통과 (3.76ms, 75.1MB)
 * 테스트 9 〉	통과 (4.05ms, 84.4MB)
 * 테스트 10 〉	통과 (3.27ms, 72.2MB)
 * 테스트 11 〉	통과 (5.89ms, 74.4MB)
 * 테스트 12 〉	통과 (4.83ms, 74.9MB)
 * 테스트 13 〉	통과 (6.56ms, 79.5MB)
 * 테스트 14 〉	통과 (7.43ms, 72.8MB)
 * 테스트 15 〉	통과 (11.85ms, 81.2MB)
 * 테스트 16 〉	통과 (24.04ms, 72MB)
 * 테스트 17 〉	통과 (17.96ms, 94.3MB)
 * 테스트 18 〉	통과 (21.58ms, 89.2MB)
 * 테스트 19 〉	통과 (49.55ms, 108MB)
 * 테스트 20 〉	통과 (35.29ms, 108MB)
 * 테스트 21 〉	통과 (18.09ms, 84MB)
 * 테스트 22 〉	통과 (13.61ms, 83.2MB)
 * 테스트 23 〉	통과 (22.56ms, 90.7MB)
 * 테스트 24 〉	통과 (8.60ms, 78.3MB)
 * 테스트 25 〉	통과 (12.55ms, 84.6MB)
 *
 * open 개수 카운트로 매칭 가능함. 이 방법이 좋은듯.
 */
public class _괄호_변환 {

    public String solution(String p) {
        return makeUAndV(p);
    }

    // 균형 잡힌 문자열 U V 생성
    public String makeUAndV(String p) {
        String[] pArray = p.split("");
        Stack<String> stack = new Stack<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < pArray.length; i++) {
            String bracket = pArray[i];
            switch (bracket) {
                case "(":
                    left++;
                    stack.add("(");
                    break;
                case ")":
                    right++;
                    if (!stack.isEmpty() && stack.peek().equals("(")) {
                        stack.pop();
                    }
                    break;
            }
            if (i % 2 == 1 && left == right) { // 2개들어갔을때 좌우 개수가 맞는다면
                // u = 0~i // v= i+1 ~ length
                String u = Arrays.stream(pArray).limit(i + 1).reduce(String::concat).orElse("");
                String v = Arrays.stream(pArray).skip(i + 1).reduce(String::concat).orElse("");
                if (stack.isEmpty()) {
                    return u + makeUAndV(v);
                } else {
                    return reverseU(u, v);
                }
            }
        }
        return p;
    }

    public String reverseU(String u, String v) {
        StringBuilder sb = new StringBuilder("(");
        sb.append(makeUAndV(v));
        sb.append(")");
        for (int i =1; i< u.length()-1; i++){
            if(u.charAt(i) == '('){
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // ()))((()
        System.out.println(new _괄호_변환().solution("()))((()"));
    }
}
