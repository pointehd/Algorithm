package month2009.day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		Solution1 sol = new Solution1();
		sol.solution(progresses, speeds);
		
	}
	// 옛날에 푼 문제.
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
	
	// 20.09.07 푼 문제.
	public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<Integer>();
        int startIndex = 0;
        while (startIndex < progresses.length){
            for(int i=startIndex; i<progresses.length; i++){
                progresses[i] += speeds[i];
            }
            int delete = 0;
            for(int i=startIndex; i<progresses.length; i++){
                if (progresses[i] >= 100){
                    delete++;
                } else {
                	if(delete >0) {
                		startIndex += delete;
                        result.add(delete);
                	}
                    break;
                }
                if(i==progresses.length-1) {
                	startIndex += delete;
                    result.add(delete);
                }
            }
        }
        int[] resultArray = new int[result.size()];
        for(int i=0;i < result.size(); i++){
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }
}
