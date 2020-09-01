package month2008.day30;

public class Souution1 {

    public int maxProfit(int[] prices) {
    	int minIndex = 0;
        int maxProfit = 0;
        
        for(int i=0; i< prices.length; i++){
            if ( prices[i] < prices[minIndex]) {
            	minIndex = i;
            } else {
            	maxProfit = prices[i] - prices[minIndex] > maxProfit ? prices[i] - prices[minIndex] : maxProfit;
            }
        }
        return maxProfit;
    }
}
