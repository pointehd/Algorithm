package year2022.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BaekJoon
 * https://www.acmicpc.net/problem/9012
 *
 * RunTime : 156 ms
 * Memory : 1,6368 KB
 * */
class _9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String countList = br.readLine();
        int count = Integer.parseInt(countList);
        for (int i = 0; i < count; i++) {
            String brackets = br.readLine();
            System.out.println(checkBrackets(brackets));
        }
        br.close();
    }

    public static String checkBrackets(String brackets) {
        while (brackets.contains("()")) {
            brackets = brackets.replaceAll("\\(\\)", "");
        }
        if (brackets.length() > 0) {
            return "NO";
        }
        return "YES";
    }
}
