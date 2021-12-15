package year2021.programmers;

/**
 * Programmers. 타겟 넘버
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 *
 * 테스트 1 〉	통과 (4.84ms, 76.8MB)
 * 테스트 2 〉	통과 (8.77ms, 76.3MB)
 * 테스트 3 〉	통과 (0.17ms, 73.3MB)
 * 테스트 4 〉	통과 (0.33ms, 80.5MB)
 * 테스트 5 〉	통과 (0.50ms, 74.8MB)
 * 테스트 6 〉	통과 (0.25ms, 68.3MB)
 * 테스트 7 〉	통과 (0.18ms, 73.2MB)
 * 테스트 8 〉	통과 (0.33ms, 78.2MB)
 * */
public class TargetNumber {
    int[] numbers;
    int target;
    int answer = 0;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        checkTargetNumber(0, 0);
        return this.answer;
    }

    private void checkTargetNumber(int index, int sum){
        if(index == numbers.length){
            if(sum == this.target){
                this.answer++;
            }
            return ;
        }
        checkTargetNumber(index+1, sum+numbers[index]);
        checkTargetNumber(index+1, sum-numbers[index]);
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(new TargetNumber().solution(numbers, target));
    }
}
