package month2009.week4;

import java.util.Stack;

public class BigNumberMaker {
	
	public static void main(String[] args) {
		String numberStr = "4177252841";
		int k = 4;
		System.out.println(makeBigNumber(numberStr, k));
	}
	
	/**
		테스트 1 〉	통과 (0.24ms, 52.3MB)
		테스트 2 〉	통과 (0.35ms, 52.9MB)
		테스트 3 〉	통과 (0.42ms, 52.1MB)
		테스트 4 〉	통과 (1.34ms, 52.8MB)
		테스트 5 〉	통과 (1.76ms, 53.3MB)
		테스트 6 〉	통과 (7.30ms, 53.5MB)
		테스트 7 〉	통과 (22.43ms, 53.7MB)
		테스트 8 〉	통과 (31.77ms, 55MB)
		테스트 9 〉	통과 (52.00ms, 59.6MB)
		테스트 10 〉	통과 (91.58ms, 60.4MB)
		테스트 11 〉	통과 (0.23ms, 52.5MB)
		테스트 12 〉	통과 (0.20ms, 52.4MB)
	 * */
	public static String makeBigNumber(String numbers, int k) {
		char[] result = new char[numbers.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<numbers.length(); i++) {
            char c = numbers.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k > 0) {
            	k--;
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
	}
	
}
