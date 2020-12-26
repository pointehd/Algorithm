package month2012.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] numbers = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(DecreasingNumbersSolution(numbers));
	}
	
	public static int DecreasingNumbersSolution(int[] numbers) {
		int[] memory = new int[numbers.length];
		int max = 0;
		for(int i=0; i<numbers.length; i++) {
			for(int j=0; j<=i; j++) {
				if(i==j) {
					memory[i] ++;
				} else if (numbers[j] > numbers[i] && memory[j] > memory[i]) {
					memory[i]  = memory[j];
				}
			}
			if(max < memory[i]) {
				max = memory[i];
			}
		}
		return max;
	}
}
