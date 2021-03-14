package year2021.programmers;

public class TriangleSnail {
    /**
     * 테스트 1 〉	통과 (0.01ms, 52.6MB)
     * 테스트 2 〉	통과 (0.02ms, 52.4MB)
     * 테스트 3 〉	통과 (0.02ms, 52.3MB)
     * 테스트 4 〉	통과 (0.20ms, 54.7MB)
     * 테스트 5 〉	통과 (0.21ms, 52.9MB)
     * 테스트 6 〉	통과 (0.22ms, 53.3MB)
     * 테스트 7 〉	통과 (7.51ms, 112MB)
     * 테스트 8 〉	통과 (7.63ms, 112MB)
     * 테스트 9 〉	통과 (7.70ms, 110MB)
     * */
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
