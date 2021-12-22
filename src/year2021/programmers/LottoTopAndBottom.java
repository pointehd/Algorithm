package year2021.programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Programmers. 로또의 최고 순위오 최저순위
 * https://programmers.co.kr/learn/courses/30/lessons/77484
 *
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
        top = top < 1 ? 1 : top;
        int bottom = 7-match;
        if(bottom > 6) {
            bottom = 6;
        }else if(bottom < 1){
            bottom = 1;
        }
        return new int[] {top, bottom};
    }

    public static void main(String[] args) {
        int[] lottos = {0, 21, 22, 23, 1, 0};
        int[] win_numbs = {31, 10, 45, 1, 6, 19};
        Arrays.stream(new LottoTopAndBottom().solution(lottos, win_numbs))
                .forEach(System.out::println);

    }
}
