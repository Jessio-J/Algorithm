package jianzhiOffer.P63;

public class P63_2 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 0;i<prices.length-1;i++){
            int differ = prices[i+1] - prices[i];
            if(differ>0){
                profit+=differ;
            }
        }
        return profit;
    }
}
