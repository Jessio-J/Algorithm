package P7;

//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//
//示例 1:
//
//输入: 123
//输出: 321
// 示例 2:
//
//输入: -123
//输出: -321
//示例 3:
//
//输入: 120
//输出: 21
//注意:
//
//假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

public class P7_ReverseInteger {
    public int reverse(int x) {
        String result;
        String result2 = "";
        if(x<0){
            result = String.valueOf(x).substring(1,String.valueOf(x).length());
        }else {
            result = String.valueOf(x);
        }
        for(int i=1;i<=result.length();i++){
            result2 += result.charAt(result.length()-i);
        }
        long templong = (long)(Integer.MAX_VALUE)+(x<0?1:0);
        if(Long.parseLong(result2)>templong){
            return 0;
        }
        return Integer.parseInt((x<0?"-":"")+result2);
    }
}
