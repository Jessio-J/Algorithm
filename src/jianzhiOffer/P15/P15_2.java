package jianzhiOffer.P15;

public class P15_2 {
    public int NumberOf1(int n) {
        int count = 0;
        while(n!=0){
            count++;
            //将n最低位的1，变成0
            //n皇后的位运算解法中也用到了这个方法
            n = (n-1)&n;
        }
        return count;
    }
}
