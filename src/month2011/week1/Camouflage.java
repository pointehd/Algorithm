package month2011.week1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Camouflage {
	
	public static int camouflage(String[][] clothes) {
		int answer = 1;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0;i<clothes.length; i++) {
			String key = clothes[i][1];
			if(map.containsKey(key)) {
				map.put(key, map.get(key)+1);
			}else {
				map.put(key, 1);
			}
		}
		
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			answer = answer*(map.get(it.next())+1);
		}
		
		return answer-1;
	}
}
