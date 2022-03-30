package year2022.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon. 스택
 * https://www.acmicpc.net/problem/10828
 *
 * Memory: 18,820 KB
 * RunTime: 396 ms
 * */
public class _10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack stack = new Stack(n);
        for(int i=0; i< n;i++) {
            String line = br.readLine();
            String[] methodAndNumber = line.split(" ");
            stack.run(methodAndNumber[0], methodAndNumber.length >1 ? Integer.parseInt(methodAndNumber[1]) : null);
        }
        br.close();
    }

    static class Stack {
        int[] stack;
        int size = 0;

        Stack(int n) {
            this.stack = new int[n];
        }
        public void run(String method, Integer num) {
            switch (method){
                case "push":
                    push(num);
                    break;
                case "pop":
                    pop();
                    break;
                case "size":
                    size();
                    break;
                case "empty":
                    empty();
                    break;
                case "top":
                    top();
                    break;
            }
        }

        private void push(int n) {
            stack[size++] = n;
        }
        private void pop() {
            System.out.println(size == 0 ? -1 : stack[--size]);
        }
        private void size() {
            System.out.println(size);
        }
        private void empty() {
            System.out.println(this.size == 0 ? 1 : 0);
        }
        private void top() {
            System.out.println(this.size == 0 ? -1 : this.stack[size-1]);
        }
    }
}
