package month2009.day08;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {	
	public static void main(String[] args) {
		int n = 3;
		int[] lost = {2,3};
		int[] reserve = {1,2};
		
		System.out.println("result : "+ solution(n, lost, reserve));
	}
	
	/*
	 * 테스트 1 〉	통과 (0.07ms, 68.1MB)
	테스트 2 〉	통과 (0.08ms, 70.3MB)
	테스트 3 〉	통과 (0.10ms, 69.1MB)
	테스트 4 〉	통과 (0.06ms, 69.4MB)
	테스트 5 〉	통과 (0.12ms, 69.7MB)
	테스트 6 〉	통과 (0.05ms, 68.4MB)
	테스트 7 〉	통과 (0.10ms, 69.8MB)
	테스트 8 〉	통과 (0.07ms, 69.6MB)
	테스트 9 〉	통과 (0.07ms, 69MB)
	테스트 10 〉	통과 (0.07ms, 68.8MB)
	테스트 11 〉	통과 (0.06ms, 68.5MB)
	테스트 12 〉	통과 (0.05ms, 68.8MB)*/
	public static int solution(int n, int[] lost, int[] reserve) {
		Set<Integer> set = new HashSet<Integer>();
		for(int num : lost) {
			set.add(num);
		}
		for(int i = 0 ;i<reserve.length; i++) {
			if(set.contains(reserve[i])) {
				set.remove(reserve[i]);
				reserve[i] = -1;
			}
		}
		for(int i = 0 ;i<reserve.length; i++) {
			if(set.contains(reserve[i]-1)) {
				set.remove(reserve[i]-1);
			} else if(set.contains(reserve[i]+1)) {
				set.remove(reserve[i]+1);
			}
		}
		
		return n - set.size();
	}
}
