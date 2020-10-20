package month2010.week4;

import java.util.ArrayList;
import java.util.List;

public class ChsheMemory {
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
