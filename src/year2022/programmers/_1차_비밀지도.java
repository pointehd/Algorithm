package year2022.programmers;

import java.util.Arrays;

/**
 * Programmers. [1차] 비밀지도
 * https://programmers.co.kr/learn/courses/30/lessons/17681
 *
 * 테스트 1 〉	통과 (2.86ms, 66.6MB)
 * 테스트 2 〉	통과 (2.71ms, 77.8MB)
 * 테스트 3 〉	통과 (2.38ms, 67.3MB)
 * 테스트 4 〉	통과 (2.51ms, 83MB)
 * 테스트 5 〉	통과 (2.14ms, 78.5MB)
 * 테스트 6 〉	통과 (2.56ms, 80.2MB)
 * 테스트 7 〉	통과 (2.52ms, 72.2MB)
 * 테스트 8 〉	통과 (2.32ms, 73.8MB)
 */
class _1차_비밀지도 {

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String temp1 = Integer.toBinaryString(arr1[i]);
            while (temp1.length() != n) {
                temp1 = "0" + temp1;
            }

            String temp2 = Integer.toBinaryString(arr2[i]);
            while (temp2.length() != n) {
                temp2 = "0" + temp2;
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(temp1.charAt(j) == '1' || temp2.charAt(j) == '1' ? "#" : " ");
            }
            answer[i] = sb.toString();
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        Arrays.stream(new _1차_비밀지도().solution(n, arr1, arr2))
            .forEach(System.out::println);
    }
}
