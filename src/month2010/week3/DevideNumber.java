package month2010.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DevideNumber {
	public static void main(String[] args) {
		
	}
	
	public int[] divide(int[] arr, int divisor) {
		List<Integer> list = new ArrayList<Integer>();
		for(int num : arr) {
			if(num % divisor == 0) {
				list.add(num);
			}
		}
		if(list.size() == 0) {
			return new int[]{-1};
		}
		Collections.sort(list);
		int [] result = new int[list.size()];
		for(int i =0; i< list.size(); i++) {
			result[i] = list.get(i);
		}
		 
		return result;
	}
	
	
	/**
	 * 다른사람 풀이 와우!
	 * */
	 public int[] divisible(int[] array, int divisor) {
	        //ret에 array에 포함된 정수중, divisor로 나누어 떨어지는 숫자를 순서대로 넣으세요.
	        return Arrays.stream(array).filter(factor -> factor % divisor == 0).toArray();
    }
}
