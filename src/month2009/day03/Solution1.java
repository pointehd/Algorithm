package month2009.day03;

public class Solution1 {
	
	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		String s= "aabbaccc";
//		String s = "ababcdcdababcdcd";
		int min = s.length();
		
		for(int i=1; i<s.length(); i++) {
			int aa = sol.solution(s, i);
			System.out.println(i+ ":" + aa);
			if(min > aa) {
				min = aa;
			}
		}
		
		System.out.println(min);
	}
	
    public int solution(String s, int sliceCount){
        int length = 0;
        String shortStr = s.substring(0, sliceCount);
        int count = 0;
        while(true ){
        	if(s.startsWith(shortStr)) {
        		count++;
        		try {
        			s = s.substring(sliceCount, s.length());
				} catch (Exception e) {
					System.out.println("악 ");
					if(count == 1) {
	        			length += sliceCount;
	        		}else {
	        			length += sliceCount + (count+"").split("").length;	
	        		}
	        		return length;
				}
        	}else {
        		
        		if(count == 1) {
        			length += sliceCount;
        		}else {
        			length += sliceCount + (count+"").split("").length;	
        		}
        		try {
        			shortStr = s.substring(0, sliceCount);	
				} catch (Exception e) {
					System.out.println("length:"+length+" "+s+"\n");
					length += s.length();
					return length;
				}
        		count = 0;
        		
        	}
        	
        	
        }
    }
}
