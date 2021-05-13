package year2021.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 느낀점
 * 2021. 05. 12 : 이게 dp 문제라니 상상도 못했다...
 * 2021. 05. 13 : 쉬운듯 어려운듯~
 * */
public class MakeOne {
    static Integer[] dp;
    /**
     * Memory : 6,7152 KB
     * Run time : 264 ms
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new Integer[n + 1];
        dp[0] = dp[1] = 0;

        System.out.print(solution(n));

    }

    static int solution(int n) {
        if(dp[n] == null){
            if(n%6 == 0) { // n이 3,2 로 나누어떨어질때
                dp[n] = Math.min(Math.min(solution(n/3), solution(n/2)), solution(n-1))+1;
            } else if(n%3 ==0) { // 3으로 나누어떨어질때
                dp[n] = Math.min(solution(n/3), solution(n-1))+1;
            } else if(n%2 ==0) { // 2로 나누어떨어질때
                dp[n] = Math.min(solution(n/2), solution(n-1))+1;
            } else {
                dp[n] = solution(n-1)+1;
            }
        }
        return dp[n];
    }
}
