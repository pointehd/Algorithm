package month2011.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HIndex {
	public static void main(String[] args) {
		HIndex hIndex = new HIndex();
		int[] citations = {3,0,6,1,5};
		hIndex.hIndex(citations);
	}
	
	public int hIndex(int[] citations) {
		int result = 0;
		
		List<Integer> list = new ArrayList<Integer>();
		for(int num : citations) {
			list.add(num);
		}
		
		Collections.sort(list);
		
		for (int i=0; i< list.size(); i++) {
			if(list.size() - i <  list.get(i)) {
				return list.get(i-1);
			}
		}
		return result;
	}
}
