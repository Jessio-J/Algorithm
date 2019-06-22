package jianzhiOffer.P44;

public class P44 {
    public int digitAtIndex(int index){
        if(index<0){
            return -1;
        }
        int digits = 1;
        while (true){
            int numbers = countOfIntegers(digits);
            if(index<numbers*digits)
                return digitAtIndex(index,digits);
            index -=digits*numbers;
            digits++;
        }
    }
    private int countOfIntegers(int digits){
        if(digits==1){
            return 10;
        }
        int count = (int)Math.pow(10,digits-1);
        return 9*count;
    }
    private int digitAtIndex(int index,int digits){
        //找到该数字
        int number = beginNumber(digits)+index/digits;
        //找到对应数字的第几位
        int indexFromRight = digits-index%digits;
        for(int i = 1;i<indexFromRight;i++){
            //把数字移到个位上
            number/=10;
        }
        //取各位
        return number%10;
    }
    private int beginNumber(int digits){
        if(digits==1)
            return 0;
        return (int)Math.pow(10,digits-1);
    }
}
