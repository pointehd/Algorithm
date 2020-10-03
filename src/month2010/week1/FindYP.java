package month2010.week1;

public class FindYP {

	/**
	 * 	테스트 1 〉	통과 (0.02ms, 52.6MB)
		테스트 2 〉	통과 (0.02ms, 53.9MB)
		테스트 3 〉	통과 (0.02ms, 52.4MB)
		테스트 4 〉	통과 (0.02ms, 51.8MB)
		테스트 5 〉	통과 (0.02ms, 51.8MB)
		테스트 6 〉	통과 (0.02ms, 52.1MB)
		테스트 7 〉	통과 (0.02ms, 52.8MB)
		테스트 8 〉	통과 (0.04ms, 52.8MB)
		테스트 9 〉	통과 (0.02ms, 51.9MB)
		테스트 10 〉	통과 (0.02ms, 52.1MB)
		테스트 11 〉	통과 (0.04ms, 52.5MB)
		테스트 12 〉	통과 (0.04ms, 52.2MB)
		테스트 13 〉	통과 (0.04ms, 52.4MB)
		테스트 14 〉	통과 (0.04ms, 52.1MB)
		테스트 15 〉	통과 (0.03ms, 52MB)
		테스트 16 〉	통과 (0.03ms, 52.4MB)
		테스트 17 〉	통과 (0.03ms, 52.8MB)
		테스트 18 〉	통과 (0.03ms, 53.2MB)
		테스트 19 〉	통과 (0.03ms, 53MB)
		테스트 20 〉	통과 (0.03ms, 53.6MB)
		테스트 21 〉	통과 (0.02ms, 53.7MB)
		테스트 22 〉	통과 (0.04ms, 53.1MB)
		테스트 23 〉	통과 (0.03ms, 52.1MB)
		테스트 24 〉	통과 (0.02ms, 52.3MB)
		테스트 25 〉	통과 (0.03ms, 52.7MB)
		테스트 26 〉	통과 (0.02ms, 51.8MB)
		테스트 27 〉	통과 (0.04ms, 52.1MB)
		테스트 28 〉	통과 (0.03ms, 52.6MB)
	 * */
	public boolean findYp(String s) {
		int y = 0;
        int p = 0;
        for(int i =0; i< s.length(); i++){
            char ss = s.charAt(i);
            if('y' == ss || 'Y' == ss){
                y++;
            } else if ('p' == ss || 'P' == ss){
                p++;
            }
        }
        if(y == p){
            return true;
        } else{
            return false;
        }
	}
	
	// other programmer
	public boolean findYP(String s) {
		s = s.toUpperCase();

        return s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count();
	}
}
