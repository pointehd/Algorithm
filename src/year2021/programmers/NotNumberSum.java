package year2021.programmers;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Programmers. 없는 숫자 더하기
 * https://programmers.co.kr/learn/courses/30/lessons/86051
 *
 *
 테스트 1 〉	통과 (0.68ms, 72.1MB)
 테스트 2 〉	통과 (0.82ms, 83.9MB)
 테스트 3 〉	통과 (0.80ms, 77.6MB)
 테스트 4 〉	통과 (0.80ms, 72.3MB)
 테스트 5 〉	통과 (0.79ms, 75.6MB)
 테스트 6 〉	통과 (0.82ms, 78.1MB)
 테스트 7 〉	통과 (0.76ms, 76.4MB)
 테스트 8 〉	통과 (0.83ms, 76.9MB)
 테스트 9 〉	통과 (0.84ms, 75.8MB)
 * */
public class NotNumberSum {
    public int solution(int[] numbers) {
        int sum = IntStream.range(1,10)
                .sum();
        int numberSum = Arrays.stream(numbers)
                .sum();
        return sum-numberSum;
    }

    public static void main(String[] args) {
        System.out.println(new NotNumberSum().solution(new int[] {1,2,3,4,6,7,8,0}));
    }

}
