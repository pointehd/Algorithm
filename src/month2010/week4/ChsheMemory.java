package month2010.week4;

import java.util.ArrayList;
import java.util.List;

public class ChsheMemory {
	/**
	 *  테스트 1 〉	통과 (0.08ms, 52.1MB)
		테스트 2 〉	통과 (0.07ms, 53.4MB)
		테스트 3 〉	통과 (0.08ms, 52.7MB)
		테스트 4 〉	통과 (0.09ms, 53MB)
		테스트 5 〉	통과 (0.05ms, 52.2MB)
		테스트 6 〉	통과 (0.05ms, 52.7MB)
		테스트 7 〉	통과 (0.10ms, 52.5MB)
		테스트 8 〉	통과 (0.10ms, 53MB)
		테스트 9 〉	통과 (0.07ms, 53MB)
		테스트 10 〉	통과 (0.33ms, 52.2MB)
		테스트 11 〉	통과 (60.50ms, 81.5MB)
		테스트 12 〉	통과 (0.35ms, 52.6MB)
		테스트 13 〉	통과 (0.91ms, 53.3MB)
		테스트 14 〉	통과 (0.94ms, 52.5MB)
		테스트 15 〉	통과 (1.21ms, 52.4MB)
		테스트 16 〉	통과 (1.69ms, 52.7MB)
		테스트 17 〉	통과 (2.68ms, 53.4MB)
		테스트 18 〉	통과 (3.38ms, 53MB)
		테스트 19 〉	통과 (4.10ms, 52.5MB)
		테스트 20 〉	통과 (4.21ms, 52.9MB)*/
	public static int chsheMemory(int cacheSize, String[] cities) {
		int result = 0;
		List<String> memory = new ArrayList<String>();
		for(String city : cities) {
			String lowerCity = city.toLowerCase();
			if(memory.contains(lowerCity)) {
				memory.remove(lowerCity);
				memory.add(lowerCity);
				result += 1;
			}else {
				memory.add(lowerCity);
				if(memory.size() > cacheSize) {
					memory.remove(0);
				}
				result += 5;
			}
		}
		return result;
	}
}
