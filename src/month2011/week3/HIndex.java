package month2011.week3;

import java.util.Arrays;

public class HIndex {
	public static void main(String[] args) {
		HIndex hIndex = new HIndex();
		int[] citations = {3,0,6,1,5};
		System.out.println(hIndex.hIndex(citations));
	}
	
	public int hIndex(int[] citations) {
		Arrays.sort(citations);
		
		for (int i=0; i< citations.length; i++) {
			int result = citations.length - i;
			
			if(citations[i] >= result) {
				return result;
			}
		}
		return 0;
	}
}
