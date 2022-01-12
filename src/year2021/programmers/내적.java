package year2021.programmers;

public class 내적 {

    /**
     * Programmers. 내적
     * https://programmers.co.kr/learn/courses/30/lessons/70128
     *
     * 테스트 1 〉	통과 (0.03ms, 75.5MB)
     * 테스트 2 〉	통과 (0.02ms, 78.2MB)
     * 테스트 3 〉	통과 (0.02ms, 79.3MB)
     * 테스트 4 〉	통과 (0.02ms, 85MB)
     * 테스트 5 〉	통과 (0.03ms, 77.4MB)
     * 테스트 6 〉	통과 (0.03ms, 73.9MB)
     * 테스트 7 〉	통과 (0.03ms, 77.9MB)
     * 테스트 8 〉	통과 (0.03ms, 73.3MB)
     * 테스트 9 〉	통과 (0.03ms, 77.5MB)
     * */
    public int solution(int[] a, int[] b) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {-3, -1, 0, 2};
        System.out.println(new 내적().solution(a,b));
    }
}
