package year2021.programmers;

public class CompressCharacter {
	/**
	 * 	테스트 1 〉	통과 (0.34ms, 52.1MB)
		테스트 2 〉	통과 (2.45ms, 52.8MB)
		테스트 3 〉	통과 (1.37ms, 54.6MB)
		테스트 4 〉	통과 (0.34ms, 52.3MB)
		테스트 5 〉	통과 (0.02ms, 51.9MB)
		테스트 6 〉	통과 (0.33ms, 52.2MB)
		테스트 7 〉	통과 (3.82ms, 53.3MB)
		테스트 8 〉	통과 (3.00ms, 52.4MB)
		테스트 9 〉	통과 (3.65ms, 53.3MB)
		테스트 10 〉	통과 (14.84ms, 56.9MB)
		테스트 11 〉	통과 (0.75ms, 52.9MB)
		테스트 12 〉	통과 (0.64ms, 51.9MB)
		테스트 13 〉	통과 (0.84ms, 52.6MB)
		테스트 14 〉	통과 (3.88ms, 52.2MB)
		테스트 15 〉	통과 (0.89ms, 53.4MB)
		테스트 16 〉	통과 (0.21ms, 51.6MB)
		테스트 17 〉	통과 (7.02ms, 54MB)
		테스트 18 〉	통과 (6.35ms, 53.9MB)
		테스트 19 〉	통과 (6.28ms, 53.3MB)
		테스트 20 〉	통과 (20.50ms, 58.5MB)
		테스트 21 〉	통과 (14.20ms, 57.7MB)
		테스트 22 〉	통과 (13.90ms, 57.7MB)
		테스트 23 〉	통과 (11.56ms, 57.7MB)
		테스트 24 〉	통과 (13.04ms, 57.3MB)
		테스트 25 〉	통과 (14.13ms, 58.2MB)
		테스트 26 〉	통과 (16.28ms, 57.4MB)
		테스트 27 〉	통과 (11.42ms, 57.6MB)
		테스트 28 〉	통과 (0.26ms, 52.5MB)
	 * */
	public int compressCharacter(String s) {
		int min = s.length();
		
		for(int i=1; i<s.length(); i++) {
			int aa = sliceCount(s, i);
			min = min > aa ? aa : min;
		}
		return min;
    }
	
    public int sliceCount(String s, int sliceCount){
		int length = 0;
		String shortStr = s.substring(0, sliceCount);
		int count = 0;
		while(true){
			if(s.startsWith(shortStr)) {
				count++;
				s = s.substring(sliceCount, s.length());
			}else {
				if(count != 1) {
					length += (int) Math.log10(count)+1;
				}
				length +=sliceCount;
				try {
					shortStr = s.substring(0, sliceCount);	
				} catch (Exception e) {
					length += s.length();
					return length;
				}
				count = 0;
			}
		}
    }
}
