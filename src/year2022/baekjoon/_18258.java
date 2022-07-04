package year2022.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * BaekJoon
 * https://www.acmicpc.net/problem/18258
 * <p>
 * RunTime: 시간초과
 * Memory:
 */
class _18258 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int methodCount = Integer.parseInt(br.readLine());
        Queue queue = new Queue();
        for(int i=0; i< methodCount; i++){
            String method = br.readLine();
            queue.run(method);
        }
        br.close();
    }

    static class Queue {
        private List<Integer> list;
        int back;

        public Queue() {
            this.list = new ArrayList<>();
            back = -1;
        }

        private void push(int num) {
            list.add(num);
            back++;
        }

        private int pop() {

            return list.isEmpty() ? -1:  list.remove(0);
        }

        private int size() {
            return list.size();
        }

        private int empty() {
            return list.isEmpty() ? 1 : 0;
        }

        private int front() {
            return list.isEmpty() ? -1 : list.get(0);
        }

        private int back() {
            return list.isEmpty() ? -1 : list.get(list.size() - 1);
        }

        public void run(String method){
            String[] methods= method.split(" ");
            String result = null;
            switch (methods[0]) {
                case "push":
                    push(Integer.parseInt(methods[1]));
                    break;
                case "pop":
                    System.out.println(pop());
                    break;
                case "size":
                    System.out.println(size());
                    break;
                case "empty":
                    System.out.println(empty());
                    break;
                case "front":
                    System.out.println(front());
                    break;
                case "back":
                    System.out.println(back());
                    break;
                default:
            }
        }
    }
}
