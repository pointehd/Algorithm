package year2021.programmers;

public class SolidSquare {

    public static void main(String[] args) {
        int w = 12 ;
        int h = 1;

        System.out.println(new SolidSquare().solution(w,h));
    }

    /**
     * 신기한 문제!
     * 이런생각을 어찌하나요 ㅠㅠ
     * Long 이 아니면 중간에 계산이 틀어지는 오류 때문에 int -> long 형변환
     *
     * 테스트 1 〉	통과 (0.02ms, 52.6MB)
     * 테스트 2 〉	통과 (0.31ms, 52.4MB)
     * 테스트 3 〉	통과 (0.15ms, 52.5MB)
     * 테스트 4 〉	통과 (0.06ms, 52.5MB)
     * 테스트 5 〉	통과 (0.19ms, 52.8MB)
     * 테스트 6 〉	통과 (0.51ms, 52.2MB)
     * 테스트 7 〉	통과 (0.02ms, 52.5MB)
     * 테스트 8 〉	통과 (0.03ms, 52.9MB)
     * 테스트 9 〉	통과 (0.04ms, 52.3MB)
     * 테스트 10 〉	통과 (0.03ms, 52MB)
     * 테스트 11 〉	통과 (0.04ms, 52.7MB)
     * 테스트 12 〉	통과 (0.03ms, 52.8MB)
     * 테스트 13 〉	통과 (82.37ms, 53.7MB)
     * 테스트 14 〉	통과 (0.02ms, 52.8MB)
     * 테스트 15 〉	통과 (118.08ms, 51.8MB)
     * 테스트 16 〉	통과 (3.37ms, 52.6MB)
     * 테스트 17 〉	통과 (57.54ms, 52.4MB)
     * 테스트 18 〉	통과 (0.03ms, 51.6MB)
     * */
    public long solution(int w, int h){
        long n = 1;
        long min = w > h ? h : w;

        for(long i = min; i>=1; i--){
            if(w%i == 0 && h%i == 0){
                n = i;
                break;
            }
        }
        long wl = new Long(w);
        long hl = new Long(h);
        return wl * hl -(wl+hl - n);
    }
}
