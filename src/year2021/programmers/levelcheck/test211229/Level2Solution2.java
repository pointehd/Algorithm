package year2021.programmers.levelcheck.test211229;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Programmers Level2 Solution2
 * 문제 설명
 * Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.
 *
 * 이런 모양 B = Brown, Y = Yellow
 * BBBB
 * BYYB
 * BBBB
 *
 * Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.
 *
 * Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
 * 노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
 * 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
 * 입출력 예
 * brown	yellow	return
 * 10	2	[4, 3]
 * 8	1	[3, 3]
 * 24	24	[8, 6]
 * 출처
 *
 * ※ 공지 - 2020년 2월 3일 테스트케이스가 추가되었습니다.
 * ※ 공지 - 2020년 5월 11일 웹접근성을 고려하여 빨간색을 노란색으로 수정하였습니다.
 *
 *
 * 푼거같은데 채점이 안되네 고민해봐야지
 * */
public class Level2Solution2 {

    public int[] solution(int brown, int yellow) {
        return null;
    }

    public List<Integer> getDivideNumbers(int maxWidth) {
        List<Integer> list = new ArrayList<>();
        for( int i=1; i< maxWidth; i++) {
            if (maxWidth % i == 0) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int [] result =new Level2Solution2().solution(10,2);
        System.out.println(result[0] + ":" + result[1]);
        result =new Level2Solution2().solution(8,1);
        System.out.println(result[0] + ":" + result[1]);
        result =new Level2Solution2().solution(24,24);
        System.out.println(result[0] + ":" + result[1]);
    }
}
