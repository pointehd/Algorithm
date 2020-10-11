package month2010.week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumThreeToZero {
	
	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		int[] nums2 = {12,0,3,-14,5,-11,11,-5,-2,-1,6,-7,-10,1,4,1,1,9,-3,6,-15,0,6,1,6,-12,3,7,11,-6,-8,0,9,3,-7,-1,7,-10,1,13,-4,-7,-9,-7,9,3,1,-13,-3,13,8,-11,-9,-8,-3,4,-13,7,-11,5,-14,-4,-9,10,6,-9,-6,-9,-12,11,-11,-9,11,-5,0,-3,13,-14,-1,-13,7,-7,14,5,0,-4,-6,-6,-11,-2,14,-10,2,12,8,-7,-11,-13,-9,14,5,-5,-9,1,-2,6,5,-12,-1,-10,-9,-9,-10,12,11};
		SumThreeToZero sttz = new SumThreeToZero();
		sttz.threeSum2(nums);
	}
	
	/**
	 * Time Limit Exceeded
	 * */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for(int i = 0; i< nums.length-2; i++){
			for(int j=i+1; j < nums.length-1; j++){
				for(int k=j+1; k < nums.length; k++){
					if(i != j 
							&& j != k 
							&& i != k 
							&& nums[i] + nums[j] + nums[k] == 0){
						List<Integer> list = new ArrayList<Integer>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[k]);
						Collections.sort(list);
						if(!result.contains(list)) {
							result.add(list);
							System.out.println(list);
						}
					}
				}
			}
		} // end for()
		return result;
	} // end threeSum()
	
	/**
	 * ing... 모르겠따.. 3중으로가야할것같다...
	 * */
	public List<List<Integer>> threeSum2(int[] nums){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Map<Integer, Integer>  numberMap = new HashMap<Integer, Integer>();
		
		for(int i : nums) {
			if(numberMap.containsKey(i)) {
				numberMap.put(i, numberMap.get(i)+1);
			}else {
				numberMap.put(i, 1);
			}
		}
		
		numberMap.forEach((k1, v1) -> {
			if (k1 == 0 && v1 > 2) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(0);
				list.add(0);
				list.add(0);
				if(!result.contains(list)) {
					result.add(list);
					System.out.println(list);
				}
			}
			if(k1 != 0 && numberMap.containsKey(0) && numberMap.containsKey(-k1) ) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(k1);
				list.add(-k1);
				list.add(0);
				Collections.sort(list);
				if(!result.contains(list)) {
					result.add(list);
					System.out.println(list);
				}
			}
			if(k1 != 0 && numberMap.containsKey(k1) && numberMap.containsKey(-k1*2) && numberMap.get(k1)>1 ) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(k1);
				list.add(k1);
				list.add(-k1*2);
				Collections.sort(list);
				if(!result.contains(list)) {
					result.add(list);
					System.out.println(list);
				}
			}
			
//			
//			numberMap.forEach((k2, v2) -> {
//					numberMap.forEach((k3, v3) -> {
//						if((v3 == 0 && (k3 ==k2 || k1 == k3) ) 
//								|| (v2 == 0 && (k1 ==k2 || k2 == k3) ) 
//								|| (v1 == 0 && (k1 ==k2 || k1 == k3) ) 
//								|| (k1 == k2 && v1 < 1) 
//								|| (k2 == k3 && v2 < 1) 
//								|| (k1 == k3 && v1 < 1)) {
//							System.out.println("z"+k1+ k2+ k3);
//						} else if(k1 == k2 && k2 == k3 && v1 < 2){
//						} else if(k1+k2+k3 == 0) {
//							List<Integer> list = new ArrayList<Integer>();
//							list.add(k1);
//							list.add(k2);
//							list.add(k3);
//							Collections.sort(list);
//							if(!result.contains(list)) {
//								result.add(list);
//								System.out.println(list);
//							}
//						}
//					}); // end numberMap.forEach 3
//			});
		});
		return result;
	}
	
}
