package P1TO50.P8;
//请你来实现一个 atoi 函数，使其能将字符串转换成整数。
//
//        首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
//
//        当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
//
//        该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
//
//        注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
//
//        在任何情况下，若函数不能进行有效的转换时，请返回 0。
//
//        说明：
//
//        假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。如果数值超过这个范围，qing返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。
public class P8_StringToInteger {
    public int myAtoi(String str) {
            String[] strArray = str.split(" ");
            int i = 0;
            String result = "";
            //1.利用split方法去空格，以空格区分，找到第一个词
            while (i < strArray.length && strArray[i].equals("")) {
                i++;
            }
            if (i < strArray.length && !strArray[i].equals("")) {
                String temp = strArray[i];
                int j = 0;
                if (temp.charAt(0) == 45||temp.charAt(0) == 43) {
                    result += temp.charAt(0);
                    j++;
                }
                while (j < temp.length()) {
                    if (temp.charAt(j) > 47 && temp.charAt(j) < 58) {
                        result += temp.charAt(j);
                    } else {
                        break;
                    }
                    j++;
                }
            }

            if (result.equals("") || result.equals("-")||result.equals("+")) {
                return 0;
            }
            //2.去掉正负号后所有高位0
            int k=result.charAt(0) == 45 ?1:0;
            while(result.charAt(k)=='0'){
                StringBuilder sb = new StringBuilder(result);
                sb.replace(k,k+1,"");
                result = sb.toString();
                if(result.equals("") || result.equals("-")||result.equals("+")){
                    return 0;
                }
            }
            //3.判断剩余数字是否超出整数范围
            if (result.length() > 11) {
                return result.charAt(0) == 45 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            long tempvalue = Long.parseLong(result);
            if (tempvalue > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (tempvalue < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            return Integer.parseInt(result);
    }
}
