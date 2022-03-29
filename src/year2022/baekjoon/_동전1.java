package year2022.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon. 2293 동전1
 * https://www.acmicpc.net/problem/2293
 *
 * TODO 너무 어려우니 다시한번 보기.
 * <p>
 * Memory: 1,4304 KB
 * RunTime: 132 ms
 */
public class _동전1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] nk = line.split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        System.out.println(dp(k, coins));
    }

    public static int dp(int k, int[] coins) {
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for(int j=coins[i]; j<=k; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[k];
    }
}
