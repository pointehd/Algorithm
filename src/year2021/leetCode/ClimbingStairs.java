package year2021.leetCode;

/**
 * 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/submissions/
 * 
 * RunTime: 0 ms
 * Memory: 35.8 MB
 * */
public class ClimbingStairs {
	int[] result;
	public int climbStairs(int n) {
		if(n<3) {
			return n;
		}
		result = new int[n+1];
		result[0] = 0;
		result[1] = 1;
		result[2] = 2;
		for(int i=3; i<=n; i++) {
			result[i] = result[i-1] + result[i-2];
		}
		return result[n];
	}
	
	public static void main(String[] args) {
		int stairs = 45 ;
		System.out.println(new ClimbingStairs().climbStairs(stairs));
	}
}
