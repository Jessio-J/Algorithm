package P29;
//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
//
//        返回被除数 dividend 除以除数 divisor 得到的商。
//
//        示例 1:
//
//        输入: dividend = 10, divisor = 3
//        输出: 3
//        示例 2:
//
//        输入: dividend = 7, divisor = -3
//        输出: -2
//做减法，运行时间很慢
public class P29_DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(divisor==0||dividend==0){
            return 0;
        }
        if(dividend==Integer.MIN_VALUE){
            if(divisor==-1){
                return Integer.MAX_VALUE;
            }else if(divisor==1){
                return Integer.MIN_VALUE;
            }

        }
        int flag1 = 1,flag2 = 1;
        if(dividend<0){
            flag1 = -1;
            dividend = -dividend;
        }
        if(divisor<0){
            flag2 = -1;
            divisor = -divisor;
        }
        int op = flag1 * flag2;
        int rt = 0;
        while (dividend>0){
            dividend -= divisor;
            if(dividend>=0){
                rt ++;
            }
        }
        return rt*op;
    }
}
