package year2021.programmers;


import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Programmers. 프린터
 * Type: Stack & Queue
 * https://programmers.co.kr/learn/courses/30/lessons/42587?language=java
 *
 * Momoery: .
 * RunTime: .
 * */
public class Printer {

    /**
     * 테스트 1 〉	통과 (1.59ms, 74.9MB)
     * 테스트 2 〉	통과 (6.08ms, 77.9MB)
     * 테스트 3 〉	통과 (1.42ms, 77.5MB)
     * 테스트 4 〉	통과 (1.19ms, 71.2MB)
     * 테스트 5 〉	통과 (0.85ms, 76.8MB)
     * 테스트 6 〉	통과 (2.65ms, 76MB)
     * 테스트 7 〉	통과 (1.70ms, 72.8MB)
     * 테스트 8 〉	통과 (5.30ms, 80.5MB)
     * 테스트 9 〉	통과 (1.68ms, 83.1MB)
     * 테스트 10 〉	통과 (3.09ms, 76.6MB)
     * 테스트 11 〉	통과 (6.20ms, 81.6MB)
     * 테스트 12 〉	통과 (1.18ms, 76.6MB)
     * 테스트 13 〉	통과 (4.38ms, 84.7MB)
     * 테스트 14 〉	통과 (0.81ms, 75.2MB)
     * 테스트 15 〉	통과 (1.34ms, 73MB)
     * 테스트 16 〉	통과 (1.84ms, 75.3MB)
     * 테스트 17 〉	통과 (4.85ms, 75.8MB)
     * 테스트 18 〉	통과 (1.33ms, 77MB)
     * 테스트 19 〉	통과 (4.83ms, 82.6MB)
     * 테스트 20 〉	통과 (1.96ms, 73.5MB)
     * */
    public int solution(int[] priorities, int location) {
        int printCount = 0;
        int frontOrder = 0;
        while(true) {
            int tempPrint = priorities[frontOrder];
            if (highScore(tempPrint, priorities)) {
                priorities[frontOrder] = -1;
                printCount++;
                if(location == frontOrder){
                    return printCount;
                }
            }
            frontOrder = (frontOrder+1) % priorities.length;
        }
    }

    private boolean highScore(int match, int[] priorities) {
        return Arrays.stream(priorities).filter(num -> match < num).count() == 0;
        // TODO maxValue 이용하는것도 생각해보기
    }

    public static void main(String[] args) {
        System.out.println(new Printer().solution(new int[]{2,1,3,2}, 2));

    }
}
