package year2021.programmers;

public class TriangleSnail {
    public int[] solution(int n){
        int[] answer = new int[n*(n+1)/2];
        int val = 1, idx= 0, cnt =0;
        int stg = 0;
        int stg_n = n;

        while(n>0){
            // Down
            if(stg == 0){
                idx = idx + cnt;
                answer[idx] = val++;
                cnt++;
                stg_n--;
                // Down -> Side
                if(stg_n == 0){
                    stg = 1; // Side
                    stg_n = --n;
                }
            }
            // Side
            else if(stg == 1){
                answer[++idx] = val++;
                stg_n--;
                // Side -> Up
                if(stg_n == 0){
                    stg = 2; // Up
                    stg_n = --n;
                }
            }
            // Up
            else{
                idx = idx - cnt;
                answer[idx] = val++;
                cnt--;
                stg_n--;
                // Up -> Down
                if(stg_n == 0){
                    stg = 0; // Down
                    stg_n = --n;
                }
            }
        }

        return answer;
    }
}
