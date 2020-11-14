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
		int y = 3;
		int x = sum - y;
		while(x >= 3 && x >= y) {
			// yellow = (x - 2) * (y - 2)
			if((x - 2) * (y - 2) == yellow){
				answer[0] = x;
				answer[1] = y;
				break;
			}
            x--; 
            y++;
        }
		return answer;
	}
}
