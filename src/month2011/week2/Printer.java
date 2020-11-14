package month2011.week2;

public class Printer {
	
	/**
	 * 	테스트 1 〉	통과 (0.30ms, 52.7MB)
		테스트 2 〉	통과 (0.58ms, 52.2MB)
		테스트 3 〉	통과 (0.03ms, 52.7MB)
		테스트 4 〉	통과 (0.03ms, 52.3MB)
		테스트 5 〉	통과 (0.03ms, 51.9MB)
		테스트 6 〉	통과 (0.07ms, 52.2MB)
		테스트 7 〉	통과 (0.07ms, 51.9MB)
		테스트 8 〉	통과 (0.34ms, 52.4MB)
		테스트 9 〉	통과 (0.02ms, 52MB)
		테스트 10 〉	통과 (0.08ms, 52.9MB)
		테스트 11 〉	통과 (0.29ms, 51.8MB)
		테스트 12 〉	통과 (0.04ms, 52.2MB)
		테스트 13 〉	통과 (0.22ms, 52.1MB)
		테스트 14 〉	통과 (0.02ms, 51.7MB)
		테스트 15 〉	통과 (0.03ms, 52.6MB)
		테스트 16 〉	통과 (0.05ms, 52.8MB)
		테스트 17 〉	통과 (0.27ms, 53.1MB)
		테스트 18 〉	통과 (0.02ms, 52.6MB)
		테스트 19 〉	통과 (0.16ms, 52.5MB)
		테스트 20 〉	통과 (0.05ms, 52.6MB)*/
	public int printer(int[] priorities, int location) {
		int result =0;
		int now = 0;
		int max = 0;
		int cycle = 0;
		
		while(priorities[location]!= 0) {
			if(priorities[now] > max ) {
				max = priorities[now];
				cycle = 0;
			}
			if(cycle >= priorities.length) {
				priorities[now] =0;
				cycle = 0;
				result++;
				max=0;
			}
			if(now==priorities.length-1) {
				now = 0;
			}else {
				now ++;
			}
			cycle++;
		}
		return result;
	}
}
