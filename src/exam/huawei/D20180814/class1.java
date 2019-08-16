package exam.huawei.D20180814;

import java.util.Scanner;

public class class1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = Integer.toBinaryString(n);
        int[] result = new int[2];
        result[0] = 0;
        result[1] = -1;
        boolean flag = false;
        for (int i = s.length()-1; i >=2; i--) {
            if(s.substring(i-2,i+1).equals("101")){
                result[0]++;
                if(!flag){
                    result[1] = s.length()-1-i;
                    flag = true;
                }
            }

        }
        System.out.println(result[0]+" "+result[1]);

    }
}
