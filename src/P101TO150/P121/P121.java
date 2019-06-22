package P101TO150.P121;

//O(n^2)的时间复杂度
public class P121 {
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 0;i<prices.length;i++){
            for(int j = i+1;j<prices.length;j++){
                if(prices[j]-prices[i]>max){
                    max = prices[j]-prices[i];
                }
            }
        }
        return max;
    }
}
