package month2010.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SumThreeToZero {
	
	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4, 0, 3};
		int[] nums2 = {12,0,3,-14,5,-11,11,-5,-2,-1,6,-7,-10,1,4,1,1,9,-3,6,-15,0,6,1,6,-12,3,7,11,-6,-8,0,9,3,-7,-1,7,-10,1,13,-4,-7,-9,-7,9,3,1,-13,-3,13,8,-11,-9,-8,-3,4,-13,7,-11,5,-14,-4,-9,10,6,-9,-6,-9,-12,11,-11,-9,11,-5,0,-3,13,-14,-1,-13,7,-7,14,5,0,-4,-6,-6,-11,-2,14,-10,2,12,8,-7,-11,-13,-9,14,5,-5,-9,1,-2,6,5,-12,-1,-10,-9,-9,-10,12,11};
		SumThreeToZero sttz = new SumThreeToZero();
		sttz.threeSumSujin(nums);
	}
	
	/**
	 * 실행시간 : 467 ms
	 * 메모리 : 43.3 MB
	 * => 메모이제이션 사용 후 
	 * if(i!= 0 && nums[i-1] == nums[i]){
	 * 		continue;
	 * }
	 * 실행시간 :28 ms
	 * 메모리 : 43.3 MB
	 * */
	public List<List<Integer>> threeSumSujin(int[] nums){
		Set<List<Integer>> result = new HashSet<List<Integer>>();
		Map<Integer, Integer>  numberMap = new HashMap<Integer, Integer>();
		Arrays.sort(nums);
		for(int i =0; i< nums.length; i++) {
			/**
			 * 실행시간 : 28 ms
			 * 메모리 : 43.3 MB
			 * */
			if(i!= 0 && nums[i-1] == nums[i]){
                continue;
            }
			int left = i+1;
			int right = nums.length-1;
			while(left <right) {
				try {
					int sum =nums[left]+ nums[i] + nums[right];
					if(sum == 0) {
						result.add(Arrays.asList(nums[i],nums[left],nums[right]));
						right --;
						left ++;
					}else {
						if(sum > 0) {
							right--;
						}else {
							left++;
						}
					}
				} catch (Exception e) {
					break;
				}
			}
			
		}
		return new ArrayList<List<Integer>>(result);
	}
	
	public List<List<Integer>> otherClass(int[] nums){
		int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        int negNums = 0;
        int posNums = 0;
        List<List<Integer>> result = new LinkedList<>();
        int zeroNums = 0;

        for(int num : nums) {
            if(num < minVal) {
                minVal = num;
            }
            if(num > maxVal) {
                maxVal = num;
            }
            if(num == 0) {
                zeroNums++;
            } else if (num > 0) {
                posNums++;
            } else {
                negNums++;
            }
        }
        
        if(zeroNums >= 3) {
            result.add(Arrays.asList(0, 0, 0));
        }

        if(minVal >= 0 || maxVal <= 0) {
            return result;
        }
        
        int[] numMap;
        int[] negNumMap = new int[negNums];
        int[] posNumMap = new int[posNums];
        int posStart = 0;
        
        if(maxVal + 2 * minVal > 0) {
            maxVal = -2 * minVal;
        }
        if(minVal + 2 * maxVal < 0) {
            minVal = -2 * maxVal;
        }
        
        numMap = new int[maxVal - minVal + 1];
        negNums = 0;
        posNums = 0;
        
        for(int num : nums) {
            if (num >= minVal && num <= maxVal) {
                if(numMap[num - minVal]++ == 0) {
                    if (num > 0) {
                        posNumMap[posNums++] = num;
                    } else if (num < 0) {
                        negNumMap[negNums++] = num;
                    }
                }
            }
        }

        Arrays.parallelSort(posNumMap, 0, posNums);
        Arrays.parallelSort(negNumMap, 0, negNums);
        
        for(int i = negNums - 1; i >= 0; i--) {
            int nv = negNumMap[i];
            int minpv = (-nv) / 2;
            
            while(posStart < posNums && posNumMap[posStart] < minpv) {
                posStart++;
            }
                
            for (int j = posStart; j < posNums; j++) {
                int pv = posNumMap[j];
                int ln = 0 - nv - pv;
                
                if (ln >= nv && ln <= pv) {
                    if(numMap[ln - minVal] == 0) {
                        continue;
                    } else if((ln == pv || ln == nv) && numMap[ln - minVal] > 1) {
                        result.add(Arrays.asList(nv, ln, pv));
                    } else if(ln != nv && ln != pv) {
                        result.add(Arrays.asList(nv, ln, pv));
                    }
                } else if(ln < nv) {
                    break;
                }
            }
        }

        return result;
	}
	
	
}
