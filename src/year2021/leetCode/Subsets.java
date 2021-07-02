package year2021.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Subsets {

    List<List<Integer>> result = null;

    /**
     * LeetCode 78. Subsets
     * https://leetcode.com/problems/subsets/
     *
     * RunTime: 1 ms
     * Memory: 39.1 MB
     * */
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        addList(0, nums, new ArrayList<>());
        return result;
    }

    private void addList(int index, int[] nums, List<Integer> list) {
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            addList(i + 1, nums, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new Subsets().subsets(nums) // 함수 호출
                .stream().forEach(l -> { // 출력: 결과확인
            System.out.print("[");
            l.stream().map(e -> e + " ").forEach(System.out::print);
            System.out.println("]");
        });
    }
}
