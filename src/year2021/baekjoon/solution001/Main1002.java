package year2021.baekjoon.solution001;

import java.io.*;
import java.util.StringTokenizer;

public class Main1002 {
    /**
     * Memory : 1,4324 KB
     * Run Time : 152 ms
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCaseCount = Integer.parseInt(bf.readLine());
        for (int i=0; i <testCaseCount; i++){
            st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            System.out.println(otherPointCount(x1, y1, r1, x2, y2, r2));
        }
        bf.close();
    }
    public static int otherPointCount(int x1, int y1, int r1, int x2, int y2, int r2){
        // 두점 사이의 거리 구하기
        double d = Math.sqrt(Math.pow(x1 - x2,2) + Math.pow(y1 - y2,2));

        // 원의 특성을 이용하여 계산
        if (d == 0 && r1 ==  r2){
            return -1;
        } else if (d < r1 + r2 && d > Math.abs(r1-r2) ) {
            return 2;
        } else if (d == r1+r2  || d == Math.abs(r1-r2)){
            return 1;
        } else {
            return 0;
        }
    }
}
