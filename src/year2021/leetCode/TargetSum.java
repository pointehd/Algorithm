package year2021.leetCode;

public class TargetSum {

    /**
     * runtime : 532 ms
     * memory 36.7MB
     *
     * 모든 경우의 수로 탐색
     * */
    public int findTargetSumWays(int[] nums, int S){
        return dfsFind(nums, 0, 0, S);
    }
    public int dfsFind(int[] nums, int index, int sum, int s){
        if (index == nums.length){
            return s == sum ? 1 : 0;
        }
        return dfsFind(nums, index+1, sum - nums[index], s)
                + dfsFind(nums, index+1, sum + nums[index], s);
    }

    // TODO 다른 방법으로 풀어보기


}
