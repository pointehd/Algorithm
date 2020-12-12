package month2012.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestAlbum {
	
	/**
	 * 	테스트 1 〉	통과 (3.20ms, 53.5MB)
		테스트 2 〉	통과 (2.27ms, 53MB)
		테스트 3 〉	통과 (3.17ms, 52.7MB)
		테스트 4 〉	통과 (5.87ms, 52.1MB)
		테스트 5 〉	통과 (2.30ms, 54.1MB)
		테스트 6 〉	통과 (2.77ms, 53MB)
		테스트 7 〉	통과 (6.39ms, 52.3MB)
		테스트 8 〉	통과 (4.51ms, 53.2MB)
		테스트 9 〉	통과 (4.43ms, 53.7MB)
		테스트 10 〉	통과 (5.03ms, 53.5MB)
		테스트 11 〉	통과 (5.87ms, 52.8MB)
		테스트 12 〉	통과 (2.73ms, 52.6MB)
		테스트 13 〉	통과 (9.20ms, 53MB)
		테스트 14 〉	통과 (4.41ms, 52.4MB)
		테스트 15 〉	통과 (2.50ms, 52.2MB)
	 * */
	public int[] bestAlbum(String[] genres, int[] plays) {
	    List<Integer> result = new ArrayList<Integer>();
	    Map<String, List<Integer>> map = makeList(genres, plays);
	    
	    while(map.size()!=0) {
	    	String key = null;
	    	int max = 0;
	    	for(Map.Entry<String, List<Integer>>  entry : map.entrySet()) {
	    		if (max < entry.getValue().get(0)) {
	    			max = entry.getValue().get(0);
	    			key = entry.getKey();
	    		}
	    	}
	    	result.add(map.get(key).get(2));
	    	if(map.get(key).get(4) != -1) {
	    		result.add(map.get(key).get(4));
	    	}
	    	map.remove(key);
	    }
	    return result.stream().mapToInt(i->i).toArray();
    }
	
	public Map<String, List<Integer>> makeList(String[] genres, int[] plays){
		Map<String, List<Integer>>  result = new HashMap<String, List<Integer>>();
		for(int i=0; i < genres.length; i++) {
			if (!result.containsKey(genres[i])) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(plays[i]);
				list.add(plays[i]);
				list.add(i);
				list.add(-1);
				list.add(-1);
				result.put(genres[i], list);
			}else {
				List<Integer> list = result.get(genres[i]);
				list.set(0, list.get(0)+plays[i]);
				if(list.get(1) < plays[i]) {
					list.set(3, list.get(1));
					list.set(4, list.get(2));
					list.set(1, plays[i]);
					list.set(2, i);
				}else if(list.get(3) < plays[i]) {
					list.set(3, plays[i]);
					list.set(4, i);
				}
			}
		}
		return result;
	}
	
	
	
	
	public static void main(String[] args) {
		BestAlbum ba = new BestAlbum();
//		String[] genres = {"classic","pop","classic","classic","pop"};
//		int[] plays = {500,600,150,800,2500};
		
		String[] genres = {"A","A","B","A"};
		int[] plays = {5,5,6,5};
		System.out.println(Arrays.toString(ba.bestAlbum(genres, plays)));
	}
}
