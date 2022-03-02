package year2022.programmers;

/**
 * programmers. 약수의 개수와 덧셈
 * https://programmers.co.kr/learn/courses/30/lessons/77884?language=java
 *
 * 테스트 1 〉	통과 (3.89ms, 81.5MB)
 * 테스트 2 〉	통과 (0.94ms, 70.6MB)
 * 테스트 3 〉	통과 (1.25ms, 81.2MB)
 * 테스트 4 〉	통과 (0.50ms, 73.2MB)
 * 테스트 5 〉	통과 (3.29ms, 77.9MB)
 * 테스트 6 〉	통과 (0.36ms, 78.7MB)
 * 테스트 7 〉	통과 (0.15ms, 73.9MB)
 * */
class _약수의_개수와_덧셈 {

    public int solution(int left, int right) {
        int result =0;
        for(int i=left; i<= right; i++){
            if(getDivisorCount(i) % 2 == 0){
                result += i;
            } else {
                result -= i;
            }
        }
        return result;
    }

    public int getDivisorCount(int num) {
        int count = 1;
        for(int i=2; i<= num; i++){
            if(num%i == 0){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new _약수의_개수와_덧셈().solution(13,13));
    }
}
