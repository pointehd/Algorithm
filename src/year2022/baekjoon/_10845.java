package year2022.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon. 큐
 * https://www.acmicpc.net/problem/10845
 * <p>
 * Memory: 	20,912 KB
 * RunTime: 380 ms
 */
public class _10845 {
    static int[] arr;
    static int front = 0;
    static int last = 0;
    static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        arr = new int[num];
        size = 0;
        front = 0;
        last = 0;

        for (int i = 0; i < num; i++) {
            String line = br.readLine();
            String[] methodAndNumber = line.split(" ");
            run(methodAndNumber[0], methodAndNumber.length > 1 ? Integer.parseInt(methodAndNumber[1]) : null);
        }
        br.close();
    }

    public static void run(String method, Integer num) {
        switch (method) {
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
            case "front":
                front();
                break;
            case "back":
                back();
                break;
        }
    }

    public static void push(int n) {
        arr[last++] = n;
        size++;
    }

    public static void pop() {
        System.out.println(size == 0 ? -1 : arr[front++]);
        if (size != 0) {
            size--;
        }
    }

    public static void size() {
        System.out.println(size);
    }

    public static void empty() {
        System.out.println(size == 0 ? 1 : 0);
    }

    public static void front() {
        System.out.println(size == 0 ? -1 : arr[front]);
    }

    public static void back() {
        System.out.println(size == 0 ? -1 : arr[last - 1]);
    }


}
