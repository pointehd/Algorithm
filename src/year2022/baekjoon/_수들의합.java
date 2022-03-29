package year2022.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon. 1789 수들의 합
 * https://www.acmicpc.net/problem/1789
 *
 * Memory: 1,4188 KB
 * RunTime: 124 ms
 */
public class _수들의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine());
        br.close();
        System.out.println(sumNumber(num));
    }

    public static int sumNumber(long num) {
        long sum = 0;
        int i=1;
        while(sum <= num) {
            sum += i++;
        }
        return i-2;
    }
}
