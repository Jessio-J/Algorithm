package jianzhiOffer.P65;

public class P65 {
    public int Add(int num1,int num2) {
        int sum,carry;
        do{
            //计算各位相加但不进位
            sum = num1^num2;
            //计算进位信息，并左移进位
            carry  =(num1 & num2)<<1;
            num1 = sum;
            num2 = carry;
        }while (num2!=0);
        return num1;
    }
}
