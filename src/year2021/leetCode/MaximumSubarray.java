package year2021.leetCode;

public class MaximumSubarray {
    /**
     * https://leetcode.com/problems/maximum-subarray/
     * RunTime: 127 ms
     * Memory: 38.8 MB
     * */
    public int maxSubArray(int[] nums){
        int max = nums[0];
        for (int i=0; i<nums.length; i++) {
            int sum=nums[i];
            max = Math.max(max, sum);
            for (int j=i+1; j<nums.length; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaximumSubarray().maxSubArray(array));
    }
}
