package month2009.week4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BigNumberMaker {
	
	public static void main(String[] args) {
		String numberStr = "4177252841";
		int k = 4;
		List<Integer> list = makeIntegerList(numberStr);
		System.out.println("");
		System.out.println(makeBigInt(list, k));
	}
	
	public static List<Integer> makeIntegerList(String numberStr){
		List<Integer> list = new ArrayList<Integer>();
		String[] strArray = numberStr.split("");
		for(String number : strArray) {
			list.add(Integer.parseInt(number));
		}
		return list;
	}
	
	public static String makeBigInt(List<Integer> list, int k){
		Collections.sort(list);
		Collections.reverse(list);
		String result = "";
		int i = 0;
		while(result.length() < list.size() - k) {
			result = result.concat(list.get(i)+"");
			i++;
		}
		return result;
	}
	
	// 전에 푼방식.
	public static String beforeMakeBigNumber(String numbers, int k) {
		char[] result = new char[numbers.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<numbers.length(); i++) {
            char c = numbers.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
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
