package P29;
//位运算
public class P29_DivideTwoIntegers2 {
    public int divide(int dividend, int divisor) {
        //按位做异或操作，最高位符号位（相同则大于0，不相同则小于0）
        boolean isMinus = (dividend ^ divisor) < 0;
        long _dividend = Math.abs((long)dividend);
        long _divisor = Math.abs((long)divisor);
        int cnt = 0;
        //左移运算符代替除法
        for (int i = 31; i >= 0; --i) {
            if (_dividend >> i >= _divisor) {
                cnt += 1 << i;
                _dividend -= _divisor << i;
            }
        }
        if (isMinus) cnt = -cnt;
        //针对dividend=Integer.MIN_VALUE,divisor=+1或-1的情况
        if (isMinus == false && cnt < 0) cnt = Integer.MAX_VALUE;
        return cnt;
    }
}
