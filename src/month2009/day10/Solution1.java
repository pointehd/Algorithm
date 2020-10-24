package month2009.day10;


public class Solution1 {
	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		Solution1 sol = new Solution1();
		int[] result = sol.coloringBook(m, n, picture);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
	/**
	 * 실행 : 통과
	 * 제출 : 실패 
	 * */
	public int[] coloringBook(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		int[] answer = new int[2];
		
		int tmpMax = 0;
		for(int i =0; i< m; i++) {
			for(int j =0; j<n; j++) {
				if(picture[i][j] != 0) {
					tmpMax = check(i, j, m, n, picture, picture[i][j]);
					if(tmpMax > maxSizeOfOneArea) {
						maxSizeOfOneArea = tmpMax;
					}
					if(tmpMax >0)
						numberOfArea++;
				}
			}
		}
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}
	
	public int check(int x, int y, int m, int n, int[][] picture, int prev) {
		int max = 1;
		// 이미 지나간값 일때
		// 이전값과 다를때 
		if(picture[x][y] != prev) {
			return 0;
		}
		// 방문 자리 초기화 
		picture[x][y] =0;
		for(int i=0; i<4; i++) {
			int realX = x;
			int realY = y;
			// x y 더하기 
			if(i==0) {
				realX= x+1;
			}else if (i == 1) {
				realX= x-1;
			}else if (i == 2) {
				realY= y+1;
			}else if (i== 3) {
				realY = y-1;
			}
			
			if(realX < 0 || realX >= m || realY < 0 || realY >= n || picture[realX][realY] == 0) {
				continue;
			}
			if(picture[realX][realY] != prev)
				continue;
			
			max += check(realX, realY, m, n, picture, prev);
		}
		return max;
	}
}
