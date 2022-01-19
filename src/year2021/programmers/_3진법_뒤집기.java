package year2021.programmers;

/**
 * Programmers. 3진법 뒤집기
 * https://programmers.co.kr/learn/courses/30/lessons/68935
 *
 * 테스트 1 〉	통과 (8.76ms, 74.8MB)
 * 테스트 2 〉	통과 (6.94ms, 80.1MB)
 * 테스트 3 〉	통과 (7.02ms, 76MB)
 * 테스트 4 〉	통과 (8.66ms, 83.2MB)
 * 테스트 5 〉	통과 (7.16ms, 77.9MB)
 * 테스트 6 〉	통과 (7.01ms, 78.1MB)
 * 테스트 7 〉	통과 (8.79ms, 74.7MB)
 * 테스트 8 〉	통과 (8.64ms, 80.4MB)
 * 테스트 9 〉	통과 (6.59ms, 74.2MB)
 * 테스트 10 〉	통과 (8.13ms, 83.6MB)
 */
public class _3진법_뒤집기 {

    public int solution(int n) {
        String notation3 = makeNotaion10To3AndReverse(n);
        return makeNotation3To10(notation3);
    }

    public int makeNotation3To10(String notaionThreeNum) {
        return Integer.parseInt(notaionThreeNum, 3);
    }

    public String makeNotaion10To3AndReverse(int n) {
        StringBuffer sb = new StringBuffer();
        int remainder = n;
        while (remainder > 0) {
            sb.append(remainder % 3 + "");
            remainder /= 3;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(new _3진법_뒤집기().solution(9));
    }
}
