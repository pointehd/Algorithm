package year2021.programmers;

/**
 * 	테스트 1 〉	통과 (0.11ms, 52.6MB)
	테스트 2 〉	통과 (0.07ms, 52.2MB)
	테스트 3 〉	통과 (0.13ms, 53MB)
	테스트 4 〉	통과 (0.12ms, 52.7MB)
	테스트 5 〉	통과 (0.09ms, 53.1MB)
	테스트 6 〉	통과 (0.10ms, 51.7MB)
	테스트 7 〉	통과 (0.11ms, 51.9MB)
	테스트 8 〉	통과 (0.10ms, 53.3MB)
	테스트 9 〉	통과 (0.10ms, 51.6MB)
	테스트 10 〉	통과 (0.12ms, 52.6MB)
	테스트 11 〉	통과 (0.13ms, 53.1MB)
	테스트 12 〉	통과 (0.12ms, 51.8MB)
	테스트 13 〉	통과 (0.17ms, 52.2MB)
	테스트 14 〉	통과 (0.13ms, 51.5MB)
	
	효율성  테스트
	테스트 1 〉	통과 (0.13ms, 52.4MB)
	테스트 2 〉	통과 (0.14ms, 53.3MB)
	테스트 3 〉	통과 (0.14ms, 51.9MB)
	테스트 4 〉	통과 (0.12ms, 52.5MB)
	테스트 5 〉	통과 (0.14ms, 52MB)
	테스트 6 〉	통과 (0.13ms, 52.7MB)
 * */
public class World124 {
	public static String world124(int n) {
		StringBuffer sb = new StringBuffer();
		while ( n > 0 ) {
			int rest = n%3;
			n = n/3 ; 
			if ( rest==0 ) {
				sb.insert(0,4);
				n = n-1;
			} else {
				sb.insert(0,rest);
			}
		}
		return sb.toString();
	}
}
