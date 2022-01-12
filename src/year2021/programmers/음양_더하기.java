package year2021.programmers;

import org.junit.Assert;
import org.junit.Test;

public class 음양_더하기 {

    /**
     * 테스트 1 〉	통과 (0.04ms, 78.4MB)
     * 테스트 2 〉	통과 (0.04ms, 81.1MB)
     * 테스트 3 〉	통과 (0.05ms, 75.9MB)
     * 테스트 4 〉	통과 (0.07ms, 75.5MB)
     * 테스트 5 〉	통과 (0.07ms, 75.9MB)
     * 테스트 6 〉	통과 (0.06ms, 81.7MB)
     * 테스트 7 〉	통과 (0.04ms, 77.7MB)
     * 테스트 8 〉	통과 (0.05ms, 72.4MB)
     * 테스트 9 〉	통과 (0.05ms, 75.7MB)
     * */
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i< absolutes.length; i++) {
            answer += signs[i] ? absolutes[i] : -absolutes[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] absolutes = {4, 7, 12};
        boolean[] signs = {true, false, true};

        int result = 9;

        System.out.println(new 음양_더하기().solution(absolutes, signs));

    }
}
