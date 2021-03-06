package year2021.programmers;

import java.util.*;

public class TwoSumNumber {
    public static void main(String[] args) {
        int[] result = new TwoSumNumber().solution(new int[]{2,1,3,4,1});
        for(int num :result){
            System.out.println(num);
        }
    }

    /**
     * 내가 푼방식
     * */
    public int[] solution(int[] numbers) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int twoSumResult = numbers[i] + numbers[j];
                if (!result.contains(twoSumResult))
                    result.add(twoSumResult);
            }
        }
        Collections.sort(result);
        return result.stream().mapToInt(n -> n).toArray();
    }
    /**
     * 다른사람풀이
     *
     * 배운점 : stream 정렬, Set도 정렬이 되는군요
     * */
    public int[] solution2(int[] numbers){
        Set<Integer> result = new HashSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                    result.add(numbers[i] + numbers[j]);
            }
        }

        return result.stream().sorted().mapToInt(n -> n).toArray();
    }
}
