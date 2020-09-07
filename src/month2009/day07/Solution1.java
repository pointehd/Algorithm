package month2009.day07;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
	public static void main(String[] args) {
		
	}
	
	public int[] beforeSolution(int[] progresses, int[] speeds) {
		int[] answer = {};
		int size = progresses.length-1 ;
		int finish = 0;
		List<Integer> list = new ArrayList<Integer>();
		
		while(finish-1 <size) {
			for(int i=0; i<=size; i++) {
				progresses[i] += speeds[i];
			}
			int push = 0;
			for(int i=finish; i<=size; i++) {
				if(progresses[i]>=100) {
					push++;
					finish=i+1;
					if(finish==size+1) {
						list.add(push);
					}
				}else {
					if(push!=0) {
						list.add(push);
					}
					break;
				}
			}
		}
		answer = new int[list.size()];
		for(int i = 0; i<list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}
