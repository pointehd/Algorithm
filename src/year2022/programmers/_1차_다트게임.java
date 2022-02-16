package year2022.programmers;

/**
 * Programmers. 1차 다트게임
 * https://programmers.co.kr/learn/courses/30/lessons/17682
 *
 * 테스트 1 〉	통과 (0.32ms, 72.7MB)
 * 테스트 2 〉	통과 (0.25ms, 77.5MB)
 * 테스트 3 〉	통과 (0.32ms, 74.5MB)
 * 테스트 4 〉	통과 (2.30ms, 73MB)
 * 테스트 5 〉	통과 (1.67ms, 70.1MB)
 * 테스트 6 〉	통과 (1.42ms, 76.1MB)
 * 테스트 7 〉	통과 (1.34ms, 72.7MB)
 * 테스트 8 〉	통과 (0.25ms, 67.7MB)
 * 테스트 9 〉	통과 (0.31ms, 76.3MB)
 * 테스트 10 〉	통과 (0.27ms, 80.1MB)
 * 테스트 11 〉	통과 (0.23ms, 74.4MB)
 * 테스트 12 〉	통과 (0.24ms, 73.3MB)
 * 테스트 13 〉	통과 (0.63ms, 78.6MB)
 * 테스트 14 〉	통과 (0.34ms, 72.6MB)
 * 테스트 15 〉	통과 (0.24ms, 76.9MB)
 * 테스트 16 〉	통과 (0.35ms, 72.4MB)
 * 테스트 17 〉	통과 (0.36ms, 78.2MB)
 * 테스트 18 〉	통과 (0.37ms, 70.9MB)
 * 테스트 19 〉	통과 (0.26ms, 79.1MB)
 * 테스트 20 〉	통과 (0.31ms, 73.3MB)
 * 테스트 21 〉	통과 (0.27ms, 74.7MB)
 * 테스트 22 〉	통과 (0.26ms, 74.1MB)
 * 테스트 23 〉	통과 (0.25ms, 75.8MB)
 * 테스트 24 〉	통과 (0.23ms, 76.9MB)
 * 테스트 25 〉	통과 (1.98ms, 73MB)
 * 테스트 26 〉	통과 (0.23ms, 74.3MB)
 * 테스트 27 〉	통과 (1.96ms, 76.3MB)
 * 테스트 28 〉	통과 (0.34ms, 72.6MB)
 * 테스트 29 〉	통과 (0.37ms, 72.8MB)
 * 테스트 30 〉	통과 (0.27ms, 76.4MB)
 * 테스트 31 〉	통과 (0.27ms, 77.5MB)
 * 테스트 32 〉	통과 (0.34ms, 76.3MB)
 * */
public class _1차_다트게임 {

    /**
     * 이게맞나 ㅎ
     * */
    public int solution(String dartResult) {
        int sum = 0;
        int before = 0;
        int now = 0;
        for(int i=0; i< dartResult.length(); i++) {
            char dart = dartResult.charAt(i);
            switch (dart){
                case 'S':
                    break;
                case 'D':
                    now = now * now;
                    break;
                case 'T':
                    now = now * now * now;
                    break;
                case '*':
                    now *= 2;
                    sum += before;
                    break;
                case '#':
                    now *= -1;
                    break;
                default:
                    before = now;
                    sum += now;
                    if(dartResult.charAt(i) - 48 > 0 && dartResult.charAt(i+1) - 48 < 10){
                        String tenValue = Character.toString(dartResult.charAt(i))+ Character.toString(dartResult.charAt(i+1));
                        now = Integer.parseInt(tenValue);
                        i++;
                        break;
                    }
                    now = Character.getNumericValue(dart);
                    break;
            }
            System.out.println(now);
        }
        sum+=now;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new _1차_다트게임().solution("1D2S#10S"));
    }
}
