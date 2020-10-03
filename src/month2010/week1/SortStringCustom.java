package month2010.week1;


public class SortStringCustom {
	
	/**
	 * 	테스트 1 〉	통과 (0.02ms, 52MB)
		테스트 2 〉	통과 (0.03ms, 53.3MB)
		테스트 3 〉	통과 (0.12ms, 53.1MB)
		테스트 4 〉	통과 (0.11ms, 53MB)
		테스트 5 〉	통과 (0.04ms, 52.6MB)
		테스트 6 〉	통과 (0.16ms, 51.5MB)
		테스트 7 〉	통과 (0.04ms, 53.6MB)
		테스트 8 〉	통과 (0.06ms, 54.5MB)
		테스트 9 〉	통과 (0.03ms, 52.3MB)
		테스트 10 〉	통과 (0.29ms, 52.8MB)
		테스트 11 〉	통과 (0.03ms, 52.9MB)
		테스트 12 〉	통과 (0.51ms, 54MB)
	 * */
	public String[] sortString(String[] strings, int n) {
		//버블? 정렬 
		for(int i =0; i< strings.length-1; i++) {
			for(int j=i+1; j<strings.length; j++) {
				// 해당인덱스 문자가 클때 
				if(strings[i].charAt(n) > strings[j].charAt(n)) {
					String tmp = strings[i];
					strings[i] = strings[j];
					strings[j] = tmp;
				} else if (strings[i].charAt(n) == strings[j].charAt(n)) { // 같은 해당인덱스 같은 문자일 때 
					// 사전적 앞에있는단어 
					if(strings[i].compareTo(strings[j]) > 0) {
						String tmp = strings[i];
						strings[i] = strings[j];
						strings[j] = tmp;
					}
				}
			}
		}
		return strings;
	}
	
	
}
