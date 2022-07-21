package year2022.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Baekjoon. 덱
 * https://www.acmicpc.net/problem/10866
 * <p>
 * Memory:  1,8720 KB
 * RunTime: 200 ms
 */
class _10866 {
    static Deque<Integer> deque;
    static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {
        // init
        stringBuilder = new StringBuilder();
        deque = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lineCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < lineCount; i++) {
            run(br.readLine());
        }
        System.out.println(stringBuilder.toString());
        br.close();
    }

    public static void run(String method) {
        StringTokenizer st = new StringTokenizer(method, " ");
        switch (st.nextToken()) {
            case "push_front": // 정수 X를 덱의 앞에 넣는다.
                deque.addFirst(Integer.parseInt(st.nextToken()));
                break;
            case "push_back": // 정수 X를 덱의 뒤에 넣는다.
                deque.addLast(Integer.parseInt(st.nextToken()));
                break;
            case "pop_front": // 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                stringBuilder.append(deque.isEmpty() ? -1 : deque.removeFirst()).append("\n");
                break;
            case "pop_back": // 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                stringBuilder.append(deque.isEmpty() ? -1 : deque.removeLast()).append("\n");
                break;
            case "size": // 덱에 들어있는 정수의 개수를 출력한다.
                stringBuilder.append(deque.size()).append("\n");
                break;
            case "empty": // 덱이 비어있으면 1을, 아니면 0을 출력한다.
                stringBuilder.append(deque.isEmpty() ? 1 : 0).append("\n");
                break;
            case "front": // 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                stringBuilder.append(deque.isEmpty() ? -1 : deque.getFirst()).append("\n");
                break;
            case "back": // 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                stringBuilder.append(deque.isEmpty() ? -1 : deque.getLast()).append("\n");
                break;
        }
    }
}
