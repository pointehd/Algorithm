package month2011.week4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PhoneBook {
	
	
	/**
	 * 	테스트 1 〉	통과 (0.07ms, 52.7MB)
		테스트 2 〉	통과 (0.06ms, 52.8MB)
		테스트 3 〉	통과 (0.06ms, 53.4MB)
		테스트 4 〉	통과 (0.05ms, 52.3MB)
		테스트 5 〉	통과 (0.09ms, 51.8MB)
		테스트 6 〉	통과 (0.06ms, 52.2MB)
		테스트 7 〉	통과 (0.06ms, 52.9MB)
		테스트 8 〉	통과 (0.05ms, 52.8MB)
		테스트 9 〉	통과 (0.07ms, 52.6MB)
		테스트 10 〉	통과 (0.07ms, 52.9MB)
		테스트 11 〉	통과 (0.06ms, 51.5MB)
	 * */
	public boolean phoneBook(String[] phone_book) {
        Set<String> set = new HashSet<String>();
		for(String p : phone_book) {
			Iterator<String> it = set.iterator();
			while(it.hasNext()) {
				String tmp = it.next();
				int minSize = Math.min(tmp.length(), p.length());
				if(tmp.substring(0, minSize).equals(p.substring(0,minSize))) {
					return false;
				}
			}
			set.add(p);
		}
		return true;
    }
}
