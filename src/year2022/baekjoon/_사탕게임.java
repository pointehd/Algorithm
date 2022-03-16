package year2022.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BaekJoon. 사탕 게임
 * https://www.acmicpc.net/problem/3085
 */
public class _사탕게임 {
    static int MAX_CANDY = 0;

    public static void main(String[] args) throws IOException {
        MAX_CANDY = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char candyArrays[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                candyArrays[i][j] = line.charAt(j);
            }
        }
        br.close();
        System.out.println(candyGame(n, candyArrays));
    }

    public static int candyGame(int size, char[][] candyArrays) {
        for (int i = 1; i < size; i++) {
            for (int j=1; j< size; j++) {

            }
        }

        return MAX_CANDY;
    }

    public char[][] swap(char[][] candyArrays, int x1, int x2, int y1, int y2) {
        char tmp = candyArrays[x1][y1];
        candyArrays[x1][y1] = candyArrays[x2][y2];
        candyArrays[x2][y2] = tmp;
        return candyArrays;
    }

}
