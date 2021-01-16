package year2021.programmers;

public class CompressCharacter {
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
