package month2009.day10;

public class Solution1 {
	public static void main(String[] args) {
		
	}
	
	public static int[] coloringBook(int m, int n, int[][] picture) {
		int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        
        
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
	}
	
	public static int check(int x, int n, int[][] picture) {
		int max = 0;
		return check(max, n, picture) +1;
	}
}
