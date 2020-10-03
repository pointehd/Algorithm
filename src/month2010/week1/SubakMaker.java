
package month2010.week1;

public class SubakMaker {
	public static void main(String[] args) {
		System.out.println(subak(3));
		System.out.println(subakOther(5));
	}
	/**
	 *  테스트 1 〉	통과 (0.29ms, 52MB)
		테스트 2 〉	통과 (0.83ms, 52.5MB)
		테스트 3 〉	통과 (0.69ms, 52.3MB)
		테스트 4 〉	통과 (1.19ms, 53.2MB)
		테스트 5 〉	통과 (0.65ms, 52.7MB)
		테스트 6 〉	통과 (0.11ms, 53MB)
		테스트 7 〉	통과 (0.13ms, 52.1MB)
		테스트 8 〉	통과 (0.12ms, 53.2MB)
		테스트 9 〉	통과 (0.14ms, 52.5MB)
		테스트 10 〉	통과 (0.11ms, 53.1MB)
		테스트 11 〉	통과 (0.12ms, 52.7MB)
		테스트 12 〉	통과 (0.11ms, 51.7MB)
		테스트 13 〉	통과 (0.14ms, 52.5MB)
		테스트 14 〉	통과 (0.13ms, 52.6MB)
		테스트 15 〉	통과 (1.77ms, 54.1MB)
		테스트 16 〉	통과 (0.12ms, 51.7MB)
	 * */
	public static String subak(int n) {
		StringBuffer result = new StringBuffer();
		for(int i=0; i< n; i++) {
			result.append(i%2 == 1 ? "박" : "수");
		}
		return result.toString();
	}
	
	public static String subakOther(int n) {
		return new String(new char [n/2+1]).replace("\0", "수박").substring(0, n);
	}
}
