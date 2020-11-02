package month2011.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class BridgeTruck {
	/**
	 * 	테스트 1 〉	통과 (6.57ms, 52.3MB)
		테스트 2 〉	통과 (32.83ms, 54.5MB)
		테스트 3 〉	통과 (2.29ms, 53.3MB)
		테스트 4 〉	통과 (67.96ms, 63.7MB)
		테스트 5 〉	통과 (116.42ms, 76.5MB)
		테스트 6 〉	통과 (84.88ms, 72.1MB)
		테스트 7 〉	통과 (8.48ms, 52.2MB)
		테스트 8 〉	통과 (3.67ms, 52.2MB)
		테스트 9 〉	통과 (19.22ms, 52.3MB)
		테스트 10 〉	통과 (4.14ms, 52.7MB)
		테스트 11 〉	통과 (1.35ms, 52.5MB)
		테스트 12 〉	통과 (7.20ms, 53.5MB)
		테스트 13 〉	통과 (7.03ms, 52.7MB)
		테스트 14 〉	통과 (3.64ms, 52.6MB)
	 * */
	public static int bridgeTruck(int bridge_length, int weight, int[] truck_weights) {
		int result = 0;
		Queue<Integer>  qu = new ArrayBlockingQueue<Integer>(truck_weights.length);
		for(int i = 0; i<truck_weights.length; i++) {
			qu.add(truck_weights[i]);
		}
		
		int maxWeight = 0;
		List<Integer> list = new ArrayList<Integer>();
		Queue<Integer> bridgeQu = new ArrayBlockingQueue<Integer>(truck_weights.length);
		while(true) {
			if(!qu.isEmpty() && weight>=maxWeight+qu.peek()) {
				int truckWeight = qu.poll();
				bridgeQu.add(truckWeight);
				list.add(0);
				maxWeight += truckWeight;
			}
			int i=0;
			for(int a : list) {
				list.set(i, a+1);
				i++;
			}
			result ++;
			if(list.size()>0 && list.get(0)>=bridge_length) {
				list.remove(0);
				maxWeight -= bridgeQu.poll();
			}
			
			if(qu.isEmpty() && bridgeQu.isEmpty())
				break;
			
		}
		return result+1;
	}
}
