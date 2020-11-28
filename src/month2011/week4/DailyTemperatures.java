package month2011.week4;


public class DailyTemperatures {
	/**
	 * 쉽군!
	 * */
	public int[] dailyTemperatures(int[] T) {
		int[] result = new int [T.length];
		for(int i=0; i< T.length-1; i++) {
			for(int j=i+1; j< T.length; j++) {
				if(T[i] < T[j]) {
					result[i] = j-i;
					break;
				}
			}
		}
		return result;
	}
}
