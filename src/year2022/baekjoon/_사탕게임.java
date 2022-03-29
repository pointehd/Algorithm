package year2022.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BaekJoon. 사탕 게임
 * https://www.acmicpc.net/problem/3085
 * id: 3085
 *
 * Memory: 1,4228 KB
 * RunTime: 132 ms
 */
public class _사탕게임 {
    static int MAX_CANDY = 0;
    static int SIZE = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SIZE = Integer.parseInt(br.readLine());
        char candyArrays[][] = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            String line = br.readLine();
            for (int j = 0; j < SIZE; j++) {
                candyArrays[i][j] = line.charAt(j);
            }
        }
        br.close();
        System.out.println(candyGame(candyArrays));
    }

    public static int candyGame(char[][] candyArrays) {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (y + 1 < SIZE) {
                    swap(candyArrays, x, x, y, y + 1);
                    maxRow(candyArrays, x);
                    maxCol(candyArrays, y);
                    maxCol(candyArrays, y + 1);
                    swap(candyArrays, x, x, y, y + 1);
                }
                if (x + 1 < SIZE) {
                    swap(candyArrays, x, x + 1, y, y);
                    maxCol(candyArrays, y);
                    maxRow(candyArrays, x);
                    maxRow(candyArrays, x + 1);
                    swap(candyArrays, x, x + 1, y, y);
                }
            }
        }

        return MAX_CANDY;
    }

    public static void maxRow(char[][] candyArrays, int row) {
        int count = 1;
        char tmp = candyArrays[row][0];
        for (int i = 1; i < SIZE; i++) {
            char target = candyArrays[row][i];
            if (tmp == target) {
                count++;
            } else {
                MAX_CANDY = Math.max(MAX_CANDY, count);
                tmp = target;
                count = 1;
            }
        }
        MAX_CANDY = Math.max(MAX_CANDY, count);
    }

    public static void maxCol(char[][] candyArrays, int col) {
        int count = 1;
        char tmp = candyArrays[0][col];
        for (int i = 1; i < SIZE; i++) {
            char target = candyArrays[i][col];
            if (tmp == target) {
                count++;
            } else {
                MAX_CANDY = Math.max(MAX_CANDY, count);
                tmp = target;
                count = 1;
            }
        }
        MAX_CANDY = Math.max(MAX_CANDY, count);
    }

    public static void swap(char[][] candyArrays, int x1, int x2, int y1, int y2) {
        char tmp = candyArrays[x1][y1];
        candyArrays[x1][y1] = candyArrays[x2][y2];
        candyArrays[x2][y2] = tmp;
    }

}
