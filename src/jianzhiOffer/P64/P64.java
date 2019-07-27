package jianzhiOffer.P64;

public class P64 {
    public int Sum_Solution(int n) {
        int ans = 0;
        if(n==0){
            return 0;
        }else{
            ans = n + Sum_Solution(n-1);
        }
        return ans;
    }
}
