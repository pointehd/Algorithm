package year2021.programmers;

public class World124 {
	public static String world124(int n) {
		StringBuffer sb = new StringBuffer();
		while ( n > 0 ) {
			int rest = n%3;
			n = n/3 ; 
			if ( rest==0 ) {
				sb.insert(0,4);
				n = n-1;
			} else {
				sb.insert(0,rest);
			}
		}
		return sb.toString();
	}
}
