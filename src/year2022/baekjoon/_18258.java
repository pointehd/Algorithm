package year2022.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BaekJoon
 * https://www.acmicpc.net/problem/18258
 * <p>
 * RunTime: 37,9836 KB
 * Memory: 1268 msㅎ
 *
 * 이게 이렇게 어렵네
 */
class _18258 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int methodCount = Integer.parseInt(br.readLine());
        Deque<String> deque = new LinkedList<>();
        StringTokenizer stringTokenizer;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < methodCount; i++) {
            stringTokenizer = new StringTokenizer(br.readLine(), " ");
            switch (stringTokenizer.nextToken()) {
                case "push":
                    deque.push(stringTokenizer.nextToken());
                    break;
                case "pop":
                    if(deque.isEmpty()) {
                        stringBuilder.append("-1\n");
                    }else {
                        stringBuilder.append(deque.removeLast()).append("\n");
                    }
                    break;
                case "size":
                    stringBuilder.append(deque.size()).append("\n");
                    break;
                case "empty":
                    if(deque.isEmpty()) {
                        stringBuilder.append("1\n");
                    }else {
                        stringBuilder.append("0\n");
                    }
                    break;
                case "front":
                    if(deque.isEmpty()) {
                        stringBuilder.append("-1\n");
                    }else {
                        stringBuilder.append(deque.getLast()).append("\n");
                    }
                    break;
                case "back":
                    if(deque.isEmpty()) {
                        stringBuilder.append("-1\n");
                    }else {
                        stringBuilder.append(deque.getFirst()).append("\n");
                    }
                    break;
            }
        }
        System.out.println(stringBuilder.toString());
        br.close();
    }

}
