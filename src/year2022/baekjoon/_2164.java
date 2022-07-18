package year2022.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Baekjoon. 카드2
 * https://www.acmicpc.net/problem/2164
 * <p>
 * Memory: 4,9020 KB
 * RunTime: 276 ms
 */
class _2164 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.close();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= size; i++) {
            queue.add(i);
        }

        while (queue.size() != 1) {
            queue.poll();
            queue.add(queue.poll());
        }

        System.out.println(queue.poll());
    }
}
