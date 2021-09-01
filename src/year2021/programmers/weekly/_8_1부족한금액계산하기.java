package year2021.programmers.weekly;

/**
 * Programmers. 부족한 금액 계산하기
 * https://programmers.co.kr/learn/courses/30/lessons/82612
 *
 * Memory, RunTime : method 참고
 * */
public class _8_1부족한금액계산하기 {

    /**
     * 테스트 1 〉	통과 (0.03ms, 68.3MB)
     * 테스트 2 〉	통과 (0.03ms, 58.4MB)
     * 테스트 3 〉	통과 (0.03ms, 58.8MB)
     * 테스트 4 〉	통과 (0.02ms, 70.5MB)
     * 테스트 5 〉	통과 (0.02ms, 71.9MB)
     * 테스트 6 〉	통과 (0.02ms, 69MB)
     * 테스트 7 〉	통과 (0.03ms, 58.8MB)
     * 테스트 8 〉	통과 (0.02ms, 72.1MB)
     * 테스트 9 〉	통과 (0.03ms, 57.6MB)
     * 테스트 10 〉	통과 (0.02ms, 73.3MB)
     * 테스트 11 〉	통과 (0.02ms, 72.6MB)
     * 테스트 12 〉	통과 (0.04ms, 68.4MB)
     * 테스트 13 〉	통과 (0.03ms, 70.1MB)
     * 테스트 14 〉	통과 (0.04ms, 69.5MB)
     * 테스트 15 〉	통과 (0.05ms, 68.3MB)
     * 테스트 16 〉	통과 (0.02ms, 59.5MB)
     * 테스트 17 〉	통과 (0.05ms, 72.7MB)
     * 테스트 18 〉	통과 (0.04ms, 65.9MB)
     * 테스트 19 〉	통과 (0.06ms, 68MB)
     * 테스트 20 〉	통과 (0.06ms, 58.7MB)
     * 테스트 21 〉	통과 (0.09ms, 59.3MB)
     * 테스트 22 〉	통과 (0.05ms, 60.5MB)
     * 테스트 23 〉	통과 (0.03ms, 60.6MB)
     * */
    public long solution(int price, int money, int count) {
        long answer = money;
        long tmpPrice = price;
        for (; count > 0; tmpPrice+=price) {
            answer -= tmpPrice;
            count --;
        }

        return answer > -1 ? 0 : -answer;
    }

    public long otherSolution(long price, long money, long count) {
        return Math.max(price * (count * (count + 1) / 2) - money, 0);
    }

    public static void main(String[] args) {
        System.out.println(new _8_1부족한금액계산하기().solution(3, 20, 4));
    }
}
