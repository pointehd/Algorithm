package month2010.week1;

public class getCenterChar {
	public String getCenterString(String s) {
	      return s.length() %2 == 0 ? s.substring(s.length()/2-1, s.length()/2+1):
	        s.substring(s.length()/2, s.length()/2+1);
	}
}
