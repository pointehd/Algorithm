package month2009.day18;

public class Solution1 {
	
	private static long strangeCounter(long t ) {
		long n =1;
		while (t >= n + n + 2) {
			n += n + 2;
			
		}
		return n+n+2-t;
	}
}
