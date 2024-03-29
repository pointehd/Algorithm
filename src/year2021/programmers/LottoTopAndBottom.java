package year2021.programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Programmers. 로또의 최고 순위와 최저순위
 * https://programmers.co.kr/learn/courses/30/lessons/77484
 *
 * 테스트 1 〉	통과 (2.26ms, 77.4MB)
 * 테스트 2 〉	통과 (2.44ms, 77.6MB)
 * 테스트 3 〉	통과 (2.70ms, 78.9MB)
 * 테스트 4 〉	통과 (2.84ms, 76.3MB)
 * 테스트 5 〉	통과 (2.68ms, 77.1MB)
 * 테스트 6 〉	통과 (2.37ms, 72.1MB)
 * 테스트 7 〉	통과 (2.73ms, 76.1MB)
 * 테스트 8 〉	통과 (2.35ms, 79.2MB)
 * 테스트 9 〉	통과 (2.81ms, 77MB)
 * 테스트 10 〉	통과 (3.53ms, 78.3MB)
 * 테스트 11 〉	통과 (2.54ms, 72.4MB)
 * 테스트 12 〉	통과 (3.86ms, 78.4MB)
 * 테스트 13 〉	통과 (2.50ms, 74.5MB)
 * 테스트 14 〉	통과 (3.42ms, 79.6MB)
 * 테스트 15 〉	통과 (2.45ms, 71MB)
 * */
public class LottoTopAndBottom {

    public int[] solution(int[] lottos, int[] win_numbs) {
        List<Integer> myLottos = Arrays.stream(lottos)
                .boxed()
                .filter(num -> num != 0)
                .collect(Collectors.toList());
        List<Integer> winNumbs = Arrays.stream(win_numbs)
                .boxed()
                .collect(Collectors.toList());
        Long matchCount = myLottos.stream()
                .filter(winNumbs::contains)
                .count();
        int match =  matchCount.intValue();
        // 맞은수 =  6 - 기억하는 숫자 수  + (기억하는숫자 중 맞은수)
        int top = 1 + myLottos.size() - match;
        top = top > 6 ? 6 : top;
        int bottom = 7-match;
        if(bottom > 6) {
            bottom = 6;
        }else if(bottom < 1){
            bottom = 1;
        }
        return new int[] {top, bottom};
    }

    public static void main(String[] args) {
        int[] lottos = {4, 2, 3, 5, 15, 7};
        int[] win_numbs = {31, 10, 45, 1, 6, 19};
        Arrays.stream(new LottoTopAndBottom().solution(lottos, win_numbs))
                .forEach(System.out::println);

    }
}
