package month2010.week5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ExpressByN {
	
	public static void main(String[] args) {
		int n = 5;
		int number = 31168;
		ExpressByN expressByN = new ExpressByN();
		System.out.println(expressByN.solution(n, number));
	}
	public static int expressByN(int n, int number) {
		
		int result = -1; 
		if (n == number) {
			return 1;
		}
		
		ArrayList<Set<Integer>> list = new ArrayList<Set<Integer>>();
		Set<Integer> ss= new HashSet<Integer>();
		ss.add(n);
		list.add(ss);
		for(int i=1; i<9; i++) {
			
			Set<Integer> temp = new HashSet<Integer>();
			String strN = "";
			for(int j=0; j<i; j++) {
				strN += String.valueOf(n);
			}
			temp.add(Integer.parseInt(strN));
			list.add(temp);
			for (int j=1; j< i; j++) {
				int k = j-1;
				Set<Integer> from = list.get(j);
				Set<Integer> to = list.get(k);
				for(int n1 : from) {
					for(int n2 : to) {
						temp.add(n1 + n2);
						temp.add(n1 - n2);
						temp.add(n1 * n2);
						if(n2 != 0)
							temp.add(n1 / n2);
					}
				}
			}
			System.out.println(temp);
			if(temp.contains(number)) {
				return i;
			}
			
		}
		return result;
	}
	static int _N;
    TreeSet<Integer>[] dynamic;

    public TreeSet<Integer> solve(int n) {
        if ((dynamic[n]!=null) &&!dynamic[n].isEmpty()) return dynamic[n];//전에 있던 집합 찾기.
        int num = 0;
        for (int i = 0; i < n; i++) num = 10 * num + _N; // NNNN만들기.
        TreeSet<Integer> temp = new TreeSet<>();
        temp.add(num);
        for(int i =1; i<n;i++){
            int j = n-i;
            TreeSet<Integer> from = solve(i);
            TreeSet<Integer> to = solve(j);
            for(int n1:from) {
                for (int n2 : to) {//d[n] = d[n-1] + d[i];
                    temp.add(n1 + n2);
                    temp.add(n1 - n2);
                    temp.add(n1 * n2);
                    if(n2 != 0) temp.add(n1 / n2);
                }
            }
        }
        return dynamic[n]= temp;
    }
	public int solution(int N, int number) {
        int answer = 0;
        _N = N;

        dynamic = new TreeSet[10];
        for(int i =1 ; i<= 8; i++){
            solve(i);
            if (dynamic[i].contains(number)) return i;
        }
        return -1;
    }
}
