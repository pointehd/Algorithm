package year2021.programmers;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class MuziLive {
	/**
		테스트 26 〉	통과 (3.18ms, 52.5MB)
		테스트 27 〉	통과 (7.30ms, 54.2MB)
		테스트 28 〉	통과 (0.09ms, 53.2MB)
		테스트 29 〉	통과 (0.09ms, 52.3MB)
		테스트 30 〉	통과 (0.06ms, 52.1MB)
		테스트 31 〉	통과 (0.05ms, 53.1MB)
		테스트 32 〉	통과 (0.09ms, 53.3MB)
		효율성  테스트
		테스트 1 〉	통과 (168.83ms, 90MB)
		테스트 2 〉	통과 (110.86ms, 90MB)
		테스트 3 〉	통과 (156.60ms, 90.1MB)
		테스트 4 〉	통과 (156.69ms, 90MB)
		테스트 5 〉	통과 (148.04ms, 90.2MB)
		테스트 6 〉	통과 (126.79ms, 90.6MB)
		테스트 7 〉	통과 (167.23ms, 90.6MB)
		테스트 8 〉	통과 (130.88ms, 90.7MB)
	*/
	public int muzi2(int[] food_times, long k) {
		int cycleCount = 0;
		Set<Integer> remainderFood = new HashSet<Integer>();
		for(int i =0; i< food_times.length; i++) {
			remainderFood.add(i);
		}
		while(remainderFood.size() <= k && remainderFood.size() != 0) {
			cycleCount += k / remainderFood.size();
			k= k%remainderFood.size();
			for(int i = 0; i < food_times.length; i++) {
				int num = food_times[i];
				if(remainderFood.contains(i) && num - cycleCount <= 0) {
					remainderFood.remove(i);
					k += -(num-cycleCount);
				}
			}
		}
		System.out.println(remainderFood);
		System.out.println(cycleCount + " : " + k + ":"+remainderFood.size());
		for(int i =0; i< food_times.length; i++) {
			if(food_times[i] - cycleCount > 0) {
				if(k == 0 ) {
					return i+1;
				}
				k--;
			}
			
		}
		return -1;
	}
	/**
		테스트 26 〉	통과 (14.15ms, 52.8MB)
		테스트 27 〉	통과 (16.54ms, 52.9MB)
		테스트 28 〉	통과 (13.47ms, 53.4MB)
		테스트 29 〉	통과 (13.25ms, 52.5MB)
		테스트 30 〉	통과 (11.53ms, 54.4MB)
		테스트 31 〉	통과 (11.94ms, 53MB)
		테스트 32 〉	통과 (11.87ms, 52.7MB)
		효율성  테스트
		테스트 1 〉	실패 (시간 초과)
		테스트 2 〉	실패 (시간 초과)
		테스트 3 〉	실패 (시간 초과)
		테스트 4 〉	실패 (시간 초과)
		테스트 5 〉	실패 (시간 초과)
		테스트 6 〉	실패 (시간 초과)
		테스트 7 〉	실패 (시간 초과)
		테스트 8 〉	실패 (시간 초과)
	 * */
	public int muziLive(int[] food_times, long k) {
		int foodLength = food_times.length;
		int cycleCount = 0;
		while (foodLength <= k && foodLength != 0) {
			cycleCount ++;
			k -= foodLength;
			for (int num : food_times) {
				if(num-cycleCount == 0) {
					foodLength--;
				}
			}
		}
		System.out.println(cycleCount + " : " + k);
		for(int i =0; i< food_times.length; i++) {
			if(food_times[i] - cycleCount > 0) {
				if(k == 0 ) {
					return i+1;
				}
				k--;
			}
		}
		return -1;
	}
	@Test
	public void test() {
		MuziLive muzi = new MuziLive();
		int[] foodTimes = {3,1,100,1510};
		int k = 205;		
		assertEquals(muzi.muzi2(foodTimes, k), 4);
	}
	
}
