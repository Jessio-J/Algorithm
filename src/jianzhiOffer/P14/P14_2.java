package jianzhiOffer.P14;
//贪心算法
public class P14_2 {
    public int maxProductCutting(int length){
        if(length<2)
            return 0;
        if (length==2)
            return 1;
        if(length==3)
            return 2;
        //尽可能多地剪去长度为3的绳子
        int timesOf3 = length/3;

        //当绳子剩下长度为4的时候，不能剪3，而应该剪成2X2的
        if(length-timesOf3*3==1){
            timesOf3--;
        }
        int timesOf2 = (length-timesOf3*3)/2;
        return (int)Math.pow(3,timesOf3)*(int)Math.pow(2,timesOf2);
    }
}
