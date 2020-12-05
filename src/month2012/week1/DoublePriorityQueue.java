package month2012.week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DoublePriorityQueue {
	/**
	 * 	I 숫자	큐에 주어진 숫자를 삽입합니다.
		D 1	큐에서 최댓값을 삭제합니다.
		D -1	큐에서 최솟값을 삭제합니다.
	 * */
	/**
	 * 	테스트 1 〉	통과 (0.26ms, 52.3MB)
		테스트 2 〉	통과 (0.26ms, 52.5MB)
		테스트 3 〉	통과 (0.28ms, 52.6MB)
		테스트 4 〉	통과 (0.26ms, 52.4MB)
		테스트 5 〉	통과 (0.37ms, 52.8MB)
		테스트 6 〉	통과 (4.38ms, 52.9MB)*/
	public int[] doublePriorityQueue(String[] operations) {
		List<Integer> list = new ArrayList<Integer>();
		
		for(String operation :operations) {
			String oper = operation.substring(0, 1);
			int number = Integer.parseInt(operation.substring(2));
			if ("I".equals(oper)) {
				list.add(number);
			} else {
				if(list.size() == 0) {
					continue;
				}
				Collections.sort(list);
				list.remove(number == 1 ? list.size()-1 : 0);
			}
		}
		if(list.size() == 0) {
			int[] result = {0,0};
			return result;
		}
		Collections.sort(list);
		int[] result = {list.get(list.size()-1), list.get(0)};
		return result;
	}
}
