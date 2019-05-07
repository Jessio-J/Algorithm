package jianzhiOffer.P17;

public class P17 {
    public void printlToMaxOfNDigits(int n){
        print(new StringBuilder(),n);

    }
    public void print(StringBuilder sb,int n){
        if(n==0){
            //字符串
            sb.toString();
            //转成数字
        }else {
            for(int i = 0;i<10;i++){
                sb.append(i);
                print(sb,n-1);
            }
        }

    }
}
