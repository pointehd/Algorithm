package year2021.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 169. Majority Element
 * https://leetcode.com/problems/majority-element/
 * 
 * RunTime: 9 ms
 * Memory: 44.5 MB
 * 
 * */
public class MajorityElement {
	public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int numsHalfSize = nums.length/2 +1;
		for ( int num : nums ) {
			map.put(num, map.getOrDefault(num, 0)+1);
			if(numsHalfSize <= map.get(num)) 
				return num;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		int[] nums = {3,2,3};
	}
}
