package jianzhiOffer.P10;
//递归方法，会出现多次重复计算
public class P10 {
    public int Fibonacci(int n) {
        if(n<=0)
            return 0;
        if(n==1)
            return 1;
        return Fibonacci(n)+Fibonacci(n-1);
    }
}
