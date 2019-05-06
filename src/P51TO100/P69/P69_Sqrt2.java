package P51TO100.P69;
//牛顿迭代法
public class P69_Sqrt2 {
    public int mySqrt(int x) {
        if(x<=1){
            return x;
        }
        //最大整数值时直接返回，避免后面操作时溢出
        if(x==Integer.MAX_VALUE){
            return 46340;
        }
        int r = x;
        int tmp;
        while (r>(tmp = x/r)){
            r = (r+tmp)/2;
        }
        return r;
    }
}
