package month2011.week2;

public class Carpet {
	
	/**
	 * 	테스트 1 〉	통과 (0.02ms, 52.7MB)
		테스트 2 〉	통과 (0.02ms, 52.1MB)
		테스트 3 〉	통과 (0.05ms, 52.3MB)
		테스트 4 〉	통과 (0.02ms, 52.9MB)
		테스트 5 〉	통과 (0.01ms, 52.4MB)
		테스트 6 〉	통과 (0.08ms, 52MB)
		테스트 7 〉	통과 (0.05ms, 54.9MB)
		테스트 8 〉	통과 (0.05ms, 52MB)
		테스트 9 〉	통과 (0.05ms, 52.7MB)
		테스트 10 〉	통과 (0.06ms, 52.8MB)
		테스트 11 〉	통과 (0.03ms, 52.1MB)
		테스트 12 〉	통과 (0.03ms, 53.1MB)
		테스트 13 〉	통과 (0.02ms, 52.2MB)
	 * */
	public int[] carpat(int brown, int yellow) {
		int[] answer = new int[2];
		/**
		 * 
		 * 둘레 = 2x + 2(y-2)
		 * brown = 2x+2y-4
		 * x+y = (brown +4) /2
		 * */
		int sum = (brown + 4) / 2;
		int x = 3;
		int y = sum - x;
		while(y >= 3 && y >= x) {
			// y >= x
			// yellow = (x - 2) * (y - 2)
			if((y - 2) * (x - 2) == yellow){
				answer[0] = y;
				answer[1] = x;
				break;
			}
            y--; 
            x++;
        }
		return answer;
	}
}
