package year2021.programmers;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Programmers. 실패율
 * https://programmers.co.kr/learn/courses/30/lessons/42889
 *
 * 테스트 1 〉	통과 (4.85ms, 78.7MB)
 * 테스트 2 〉	통과 (4.52ms, 72.8MB)
 * 테스트 3 〉	통과 (6.23ms, 79.3MB)
 * 테스트 4 〉	통과 (8.06ms, 93.8MB)
 * 테스트 5 〉	통과 (9.84ms, 89MB)
 * 테스트 6 〉	통과 (5.38ms, 74.1MB)
 * 테스트 7 〉	통과 (5.50ms, 86MB)
 * 테스트 8 〉	통과 (8.10ms, 94.1MB)
 * 테스트 9 〉	통과 (9.65ms, 85.7MB)
 * 테스트 10 〉	통과 (7.10ms, 78.9MB)
 * 테스트 11 〉	통과 (7.43ms, 85.4MB)
 * 테스트 12 〉	통과 (8.36ms, 93.6MB)
 * 테스트 13 〉	통과 (10.19ms, 92.3MB)
 * 테스트 14 〉	통과 (5.68ms, 77.9MB)
 * 테스트 15 〉	통과 (6.92ms, 88.1MB)
 * 테스트 16 〉	통과 (5.73ms, 80.8MB)
 * 테스트 17 〉	통과 (9.52ms, 81.8MB)
 * 테스트 18 〉	통과 (6.34ms, 81MB)
 * 테스트 19 〉	통과 (6.76ms, 76.4MB)
 * 테스트 20 〉	통과 (6.13ms, 89MB)
 * 테스트 21 〉	통과 (10.01ms, 91.7MB)
 * 테스트 22 〉	통과 (13.07ms, 80.5MB)
 * 테스트 23 〉	통과 (14.12ms, 77.9MB)
 * 테스트 24 〉	통과 (11.08ms, 92.3MB)
 * 테스트 25 〉	통과 (5.77ms, 78.5MB)
 * 테스트 26 〉	통과 (4.30ms, 72.7MB)
 * 테스트 27 〉	통과 (5.92ms, 75MB)
 *
 *
 * Compareable 인터페이스 구현예제
 * https://codechacha.com/ko/java8-stream-sorted/
 * */
public class FailureRate {

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N+1];
        Arrays.stream(stages)
                .forEach(stage -> answer[stage-1] ++);

        Rate.totalUser = stages.length;

        return IntStream.range(0, N)
                .boxed()
                .map(index -> new Rate(index+1, answer[index]))
                .sorted()
                .mapToInt(rate -> rate.index)
                .toArray();
    }

    public static class Rate implements Comparable<Rate>{
        static double totalUser;
        int index;
        double rate;

        public Rate(int index, int failUser) {
            this.index = index;
            if(totalUser == 0) {
                this.rate = 0;
            }else {
                this.rate = failUser / totalUser;
                totalUser =  totalUser - failUser;
            }

        }
        @Override
        public int compareTo(Rate rate2) {
            if (this.rate == rate2.rate) {
                return this.index > rate2.index
                        ? 1
                        : -1;
            } else {
                if (this.rate < rate2.rate) return 1;
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        Arrays.stream(new FailureRate()
                .solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3}))
                .forEach(System.out::print);
    }
}
