package jianzhiOffer.P16;

public class P16 {
    public double Power(double base, int exponent) {
        if(exponent==0){
            return 1;
        }else if(exponent == 1){
            return base;
        }
        if(exponent<0){
            base = 1/base;
            exponent=0-exponent;
        }
        double half = Power(base,exponent>>>1);
        return half*half*Power(base,exponent&1);
    }
}
