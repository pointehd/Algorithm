package month2010.week5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ExpressByN {
	public static void main(String[] args) {
	}
	public static int expressByN(int n, int number) {
		int result = -1; 
		if (n == number) {
			return 1;
		}
		
		ArrayList<Set<Integer>> list = new ArrayList<Set<Integer>>();
		for(int i=1; i<9; i++) {
			Set<Integer> set = new HashSet<Integer>();
			String strN = "";
			for(int j=0; j<i; j++) {
				strN = String.valueOf(n);
			}
			set.add(Integer.parseInt(strN));
			
			
			
//			set.add()
//			for(int j=0;)
			
			
			
		}
		
		return result;
	}
}
