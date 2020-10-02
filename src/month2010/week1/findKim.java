package month2010.week1;

import java.util.Arrays;

public class findKim {
	
	public static void main(String[] args) {
		String[] seoul = {"Jane", "Kim"};
		System.out.println(findKim(seoul));
		System.out.println(findKim2(seoul));
	}
	/**
	 *  테스트 1 〉	통과 (7.97ms, 52.3MB)
		테스트 2 〉	통과 (9.40ms, 53.1MB)
		테스트 3 〉	통과 (8.22ms, 52.8MB)
		테스트 4 〉	통과 (8.84ms, 52MB)
		테스트 5 〉	통과 (7.97ms, 53.5MB)
		테스트 6 〉	통과 (7.99ms, 53.3MB)
		테스트 7 〉	통과 (7.87ms, 52.4MB)
		테스트 8 〉	통과 (13.57ms, 53MB)
		테스트 9 〉	통과 (8.79ms, 52.9MB)
		테스트 10 〉	통과 (10.28ms, 52.4MB)
		테스트 11 〉	통과 (7.65ms, 52.8MB)
		테스트 12 〉	통과 (8.10ms, 53.3MB)
		테스트 13 〉	통과 (8.38ms, 53.3MB)
		테스트 14 〉	통과 (8.31ms, 52.7MB)
	 * */
	public static String findKim(String[] seoul) {
		int x = Arrays.asList(seoul).indexOf("Kim");
        return "김서방은 "+x+"에 있다";
	}
	
	/**
	 *  테스트 1 〉	통과 (8.40ms, 52.6MB)
		테스트 2 〉	통과 (7.82ms, 52MB)
		테스트 3 〉	통과 (7.83ms, 52.4MB)
		테스트 4 〉	통과 (7.71ms, 52.9MB)
		테스트 5 〉	통과 (8.20ms, 52.6MB)
		테스트 6 〉	통과 (13.73ms, 52.8MB)
		테스트 7 〉	통과 (8.58ms, 55.9MB)
		테스트 8 〉	통과 (10.89ms, 53.3MB)
		테스트 9 〉	통과 (8.01ms, 52.3MB)
		테스트 10 〉	통과 (8.84ms, 52.9MB)
		테스트 11 〉	통과 (9.70ms, 52.3MB)
		테스트 12 〉	통과 (9.08ms, 52.5MB)
		테스트 13 〉	통과 (12.44ms, 53MB)
		테스트 14 〉	통과 (8.86ms, 52.8MB)
	 * */
	public static String findKim2(String[] seoul) {
        String answer = "";
        int i=0;
        while(!seoul[i].equals("Kim")){
            i++;
        }
        return "김서방은 "+i+"에 있다";
    }
}
