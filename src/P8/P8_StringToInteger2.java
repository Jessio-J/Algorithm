package P8;

public class P8_StringToInteger2 {
    public int myAtoi(String str) {
        int sum = 0;
        boolean bnegative = false;
        for (int i = 0; i < str.length();i++)
        {
            //处理开头的空格
            if (str.charAt(i) == ' ' && ((i> 0 && str.charAt(i-1) == ' ') ||( i == 0)))
                continue;
            //处理负号
            if (str.charAt(i) == '-' && ((i> 0 && str.charAt(i-1) == ' ') || (i == 0 )))
            {
                bnegative = true;
                continue;
            }
            //处理正号
            if (str.charAt(i) == '+' && ((i> 0 && str.charAt(i-1) == ' ') || (i == 0)))
            {
                bnegative = false;
                continue;
            }

            //其他字符跳出循环
            if (str.charAt(i) < '0' || str.charAt(i) > '9')
                break;

            if (bnegative && ((sum > Integer.MAX_VALUE / 10) || (sum == Integer.MAX_VALUE / 10 && (str.charAt(i) - '0') > 8)))
            {
                //负数越界
                return Integer.MIN_VALUE;
            }

            if (!bnegative && ((sum > Integer.MAX_VALUE / 10) || (sum == Integer.MAX_VALUE / 10 && (str.charAt(i) - '0') > 7)))
            {
                //正数越界
                return Integer.MAX_VALUE;
            }
            sum = sum * 10 + (str.charAt(i) - '0');
        }
        return sum = bnegative ? sum * -1 : sum;
    }
}
