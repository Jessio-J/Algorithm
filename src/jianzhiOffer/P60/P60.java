package jianzhiOffer.P60;

public class P60 {
    public void printProbability(int number){
        if(number<1){
            return;
        }
        int[] num1 = new int[6*number+1];
        int[] num2 = new int[6*number+1];
        for(int i=1;i<=6;i++){
            num1[i] = 1;
        }
        int flag = 0;
        for(int i = 2;i<=number;i++){
            if(flag==0){
                for(int j=i;j<=6*i;j++){
                    int a = j-1>=0?num1[j-1]:0;
                    int b = j-2>=0?num1[j-2]:0;
                    int c = j-3>=0?num1[j-3]:0;
                    int d = j-4>=0?num1[j-4]:0;
                    int e = j-5>=0?num1[j-5]:0;
                    int f = j-6>=0?num1[j-6]:0;
                    num2[j] = a+b+c+d+e+f;
                }
                flag = 1;
            }else {
                for(int j=i;j<=6*i;j++){
                    int a = j-1>=0?num2[j-1]:0;
                    int b = j-2>=0?num2[j-2]:0;
                    int c = j-3>=0?num2[j-3]:0;
                    int d = j-4>=0?num2[j-4]:0;
                    int e = j-5>=0?num2[j-5]:0;
                    int f = j-6>=0?num2[j-6]:0;
                    num1[j] = a+b+c+d+e+f;
                }
                flag = 0;
            }
        }
//        最后看输出哪一个数组
//        if(flag == 0){
//            num1[]
//        }else {
//            num2[]
//        }
    }
}
