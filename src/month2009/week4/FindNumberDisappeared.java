package month2009.week4;

import java.util.ArrayList;
import java.util.List;

public class FindNumberDisappeared {
	
	public static void main(String[] args) {
		int[] nums = {1,1};
		findDisappearedNumbers(nums);
		
	}
	
	public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        boolean[] arr = new boolean[nums.length];
        for(int i=0; i<nums.length; i++){
        	if(!arr[nums[i]-1])
        		arr[nums[i]-1] = !arr[nums[i]-1];
        }
        for(int i=0;i<arr.length; i++){
            if(!arr[i]){
                list.add(i+1);
            }
        }
        return list;
	}

}
