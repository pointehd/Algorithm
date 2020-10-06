package month2010.week2;

import java.util.HashMap;

public class TowSum {
	
	
	/**
	 * 내가 푼것.
	 * 실행시간 : 49 ms
	 * 메모리 : 38.9 MB
	 * */
	public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i< nums.length -1; i++){
            for(int j =i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }
	
	/**
	 * 이게뭐지? 아래꺼랑 비슷한내용인가 보다.
	 * */
	public int[] twoSum2(int[] nums, int target) {
        if (nums == null)  return null;
        int n = nums.length;
        int volumn = 2048;
        int bitmode = volumn - 1;
        int[] hashmap = new int[volumn];
        
        for (int i = 0; i<n;i++){
            int complement = target - nums[i];
            if(hashmap[complement & bitmode]!=0){
                return new int[]{hashmap[complement & bitmode] - 1, i};
            }
            hashmap[nums[i] & bitmode] = i + 1;
        }

        return null;
    }
	
	/**
	 * 혹시 천재??
	 * */
	public int[] twoSum3(int[] nums, int target) {
        HashMap <Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int offset = target - nums[i];
            
            if(map.containsKey(offset)){
                return new int[]{map.get(offset), i};
            }
            map.put(nums[i], i);
        }
        return new int []{};
    }
}
