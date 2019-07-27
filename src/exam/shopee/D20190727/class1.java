package exam.shopee.D20190727;

import java.util.Scanner;

public class class1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String str1 = in.next();
        String str2 = in.next();

        if(str1.length()<str2.length()){
            String t = str1;
            str1 = str2;
            str2 = t;
        }
        if(!str1.contains(str2)){
            System.out.println("");
        }
        int len1 = str1.length();
        int len2 = str2.length();
        int index = len2;
        while(index>=1){
            if(len1%index==0&&len2%index==0){
                String t = str2.substring(0,index);
                StringBuffer sb1 = new StringBuffer(t);
                while(sb1.length()!=str1.length()){
                    sb1.append(t);
                }
                StringBuffer sb2 = new StringBuffer(t);
                while(sb2.length()!=str2.length()){
                    sb2.append(t);
                }
                if(new String(sb1).equals(str1)&&new String(sb2).equals(str2)){
                    System.out.println(t);
                }

            }
            index--;
        }

        System.out.println("");

    }
}
