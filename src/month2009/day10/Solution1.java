package month2009.day10;

import java.util.Map;

public class Solution1 {
	public static void main(String[] args) {
		
	}
	
	public static int[] coloringBook(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		int[] answer = new int[2];
		boolean[][] check = new boolean[m][n];
		
		
		for(int i =0; i< n; i++) {
			for(int j =0; j<m; j++) {
				
			}
		}
		
		
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}
	
	public static int check(int m, int n, int[][] picture, boolean[][] checkBoolean) {
		int max = 0;
		if(picture[m][n] == picture[m][n+1]) {
			
		}else if(picture[m][n] == picture[m][n+1]) {
			
		}else if (picture[m][n] == picture[m][n+1]) {
			
		}
		return check(max, n, picture) +1;
	}
}
