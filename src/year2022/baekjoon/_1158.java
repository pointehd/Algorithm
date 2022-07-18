package year2022.baekjoon;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Baekjoon. 요세푸스
 * https://www.acmicpc.net/problem/1158
 * <p>
 * Memory:  1,8364 KB
 * RunTime:  264 ms
 */
class _1158 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        int removeCount = scanner.nextInt();
        scanner.close();
        Josephus josephus = new Josephus(count, removeCount);
        josephus.run();

    }

    public static class Josephus {
        List<Integer> list;
        int removeSize;

        public Josephus(int size, int removeSize) {
            list = new LinkedList<>();
            for (int i = 1; i <= size; i++) {
                list.add(i);
            }
            this.removeSize = removeSize;
        }

        public void run() {
            StringBuilder sb = new StringBuilder("<");
            int now = removeSize;
            while (!list.isEmpty()) {
                if (now > list.size()) {
                    now -= list.size();
                } else {
                    sb.append(list.remove(now - 1));
                    now += removeSize - 1;
                    if (!list.isEmpty()) {
                        sb.append(", ");
                    }
                }
            }
            sb.append(">");
            System.out.println(sb.toString());
        }
    }
}
