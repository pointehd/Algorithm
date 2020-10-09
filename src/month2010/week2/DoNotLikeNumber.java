package month2010.week2;

public class DoNotLikeNumber {
	public static void main(String[] args) {
		int[] arr = {1, 1, 3, 3, 0, 1, 1};
		
		int[] result = doNotLikeNumber(arr);
		for(int i=0; i< result.length; i++) {
			System.out.println(result[i]);
		}
	}
	
	/**
	 *  테스트 1 〉	통과 (0.03ms, 52.9MB)
		테스트 2 〉	통과 (0.03ms, 53.5MB)
		테스트 3 〉	통과 (0.02ms, 52.4MB)
		테스트 4 〉	통과 (0.02ms, 52.9MB)
		테스트 5 〉	통과 (0.04ms, 52.9MB)
		테스트 6 〉	통과 (0.03ms, 51.8MB)
		테스트 7 〉	통과 (0.02ms, 52.9MB)
		테스트 8 〉	통과 (0.02ms, 53MB)
		테스트 9 〉	통과 (0.03ms, 52.8MB)
		테스트 10 〉	통과 (0.03ms, 52.8MB)
		테스트 11 〉	통과 (0.02ms, 53.8MB)
		테스트 12 〉	통과 (0.02ms, 52.7MB)
		테스트 13 〉	통과 (0.02ms, 52.2MB)
		테스트 14 〉	통과 (0.03ms, 52.2MB)
		테스트 15 〉	통과 (0.02ms, 52.3MB)
		테스트 16 〉	통과 (0.02ms, 52.1MB)
		테스트 17 〉	통과 (0.02ms, 52.7MB)
		효율성  테스트
		테스트 1 〉	통과 (15.17ms, 124MB)
		테스트 2 〉	통과 (13.97ms, 123MB)
		테스트 3 〉	통과 (15.27ms, 124MB)
		테스트 4 〉	통과 (17.54ms, 123MB)
	 * */
	public static int[] doNotLikeNumber(int[] arr) {
		int[] result = new int[arr.length];
		int size = 0;
		result[0] = arr[0];
		for(int i=1; i < arr.length; i++) {
			if(result[size] != arr[i]) {
				result[++size] = arr[i];
			}
		}
		int[] rresult = new int[size+1];
		for(int i =0; i<size+1; i++) {
			rresult[i] = result[i];
		}
		return rresult; 
	}
}
