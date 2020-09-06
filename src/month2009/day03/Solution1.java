package month2009.day03;

public class Solution1 {
	
	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		String s= "aabbaccc";
//		String s = "ababcdcdababcdcd";
		System.out.println(sol.solutionLoop(s));
	}
	
	public int solutionLoop(String s) {
		int min = s.length();
		
		for(int i=1; i<s.length(); i++) {
			int aa = solution(s, i);
			min = min > aa ? aa : min;
		}
		return min;
	}
	
    public int solution(String s, int sliceCount){
        int length = 0;
        String shortStr = s.substring(0, sliceCount);
        int count = 0;
        while(true){
        	if(s.startsWith(shortStr)) {
        		count++;
    			s = s.substring(sliceCount, s.length());
        	}else {
        		if(count != 1) {
//        			length += (count+"").split("").length;
//        			숫자의 자리수를 구하는 방법 !  신기..
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
