package month2009.day18;

public class Solution1 {
	/**
	 * <pre>
	 *  최상단 시간 값이 이전 (시간+오른쪽카운터)값
	 *  (1,3) / (4,6) / (10,12) / (22,24) / (46,48)
	 *  두개를 더한게 다음 최상단의 시간값
	 *  오른쪽 카운트넌 시간 + 2
	 * </pre>
	 * */
	private static long strangeCounter(long t ) {
		long n =1;
		while (t >= n + n + 2) {
			n += n + 2;
			
		}
		return n+n+2-t;
	}
}
