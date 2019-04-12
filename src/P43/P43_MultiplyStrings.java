package P43;
//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
//        示例 1:
//
//        输入: num1 = "2", num2 = "3"
//        输出: "6"
//        示例 2:
//
//        输入: num1 = "123", num2 = "456"
//        输出: "56088"
//        说明：
//
//        num1 和 num2 的长度小于110。
//        num1 和 num2 只包含数字 0-9。
//        num1 和 num2 均不以零开头，除非是数字 0 本身。
//        不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
public class P43_MultiplyStrings {
    public String multiply(String num1, String num2) {
        String rs = "";
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        int rest = 0;
        for(int i =0;i<num1.length()+num2.length()-1;i++){
            int pos = 0;
            pos += rest;
            rest = 0;
            int j = (num2.length()-1-i)>=0?0:(i-num2.length()+1);
            while(j<num1.length()&&j<=i){
                int n1 = num1.charAt(num1.length()-1-j) - '0';
                int n2 = num2.charAt(num2.length()-1-(i-j)) - '0';
                pos += n1*n2%10;
                rest += n1*n2/10;
                j++;
            }
            rest += pos/10;
            rs =  pos%10+ rs;
        }
        if(rest>0){
            rs = rest+rs;
        }
        return rs;
    }
}
