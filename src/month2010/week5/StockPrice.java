package month2010.week5;

public class StockPrice {
	public int[] stockPrice(int[] prices) {
		int[] answer = new int[prices.length];
			
		for(int i=0; i<prices.length-1; i++) {
			int count = 0;
			for(int j=i+1; j<prices.length; j++) {
				count++;
				if(prices[i] > prices[j]) {
					break;
				}
			}
			answer[i] = count;
		}
		return answer;
	}
}
