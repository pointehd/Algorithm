package month2012.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EasyStairsNumbers {
	static final double MOD = 1000000000.0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(stairsNumberCount(n));
	}
	
	public static int stairsNumberCount(int n) {
		double[][] dp = new double[n+1][11];
		for(int i =1; i< 10; i++) {
			dp[1][i] = 1;
		}
		
		for(int i=2; i<= n; i++) {
			dp[i][0] = dp[i-1][1];
			for(int j=1; j<10; j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MOD; 
			}
		}
		double sum = 0;
		for(int i=0; i<10; i++) {
			sum += dp[n][i] ;
		}
		return (int)(sum % MOD);
	}
}
