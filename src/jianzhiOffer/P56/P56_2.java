package jianzhiOffer.P56;

public class P56_2 {
    public int FindNumberApprearingOnce(int num[]){
        if(num.length==0){
            return 0;
        }
        int[] bitSum = new int[32];
        for(int i=0;i<num.length;i++){
            int bitmask = 1;
            for(int j =31;j>=0;j++){
                int bit = num[i]&bitmask;
                if(bit!=0){
                    bitSum[j]+=1;
                }
                bitmask = bitmask<<1;
            }

        }
        int result = 0;
        for(int i = 0;i<32;i++){
            result = result<<1;
            result+=bitSum[i]%3;
        }
        return result;
    }
}
