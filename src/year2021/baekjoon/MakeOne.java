package year2021.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 느낀점
 * 2021. 05. 12 : 이게 dp 문제라니 상상도 못했다...
 * */
public class MakeOne {
    int min = 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        MakeOne one = new MakeOne();
        one.solution(0, n);
        System.out.println(one.min);
    }

    public void solution(int min, int x){
        if(x == 1){
            this.min = Math.min(this.min, min);
            return ;
        }
        if(x % 2 == 0) {
            solution(min+1, x/2);

        }
        if(x % 3 == 0) {
            solution(min+1, x/3);
        }
        if(x>1){
            solution(min+1, x-1);
        }
    }

}
