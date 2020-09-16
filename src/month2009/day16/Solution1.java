package month2009.day16;

public class Solution1 {
	
	static int howManyGames(int p, int d, int m, int s) {
        // Return the number of games you can buy
        int result = 0;
        int sum = 0;
        
        while (sum <= s) {
            sum += p;
            if (p - d >= m) {
                p -= d;
            } else {
                p = m;
            }
            result ++;
        }
        return result-1 ;
    }
}
