package jianzhiOffer.P15;
//无符号右移
public class P15 {
    public int NumberOf1(int n) {
        int count = 0;
        while(n!=0){
            if((n&1)==1){
                count++;
            }
            //使用无符号右移，可以避免出现循环的现象
            n=n>>>1;
        }
        return count;
    }
}
