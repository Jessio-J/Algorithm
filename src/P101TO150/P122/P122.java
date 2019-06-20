package P101TO150.P122;

public class P122 {
    public int maxProfit(int[] prices) {
        if(prices.length<2){
            return 0;
        }
        int[] k = new int[prices.length];
        int min = 0;
        int max = 0;
        int sum = 0;
        for (int i = 1; i < prices.length - 1; i++) {
            if(prices[i-1]>prices[i]&&prices[i+1]>prices[i]){
                k[i]=-1;
            }else if(prices[i-1]<prices[i]&&prices[i+1]<prices[i]){
                k[i]=1;
            }
        }
        if(prices[0]>prices[1]){
            k[0] = 1;
        }else {
            k[0] = -1;
        }
        if(prices[prices.length-1]>prices[prices.length-2]){
            k[prices.length-1]=1;
        }else {
            k[prices.length-1]=-1;
        }
        for(int i = 0;i < prices.length; i++){
            if(k[i]==-1){
                min = prices[i];
            }
            if(k[i]==1){
                max = prices[i];
                if(i!=0){
                    sum +=max-min;
                }
            }
        }
        return sum;
    }
}
