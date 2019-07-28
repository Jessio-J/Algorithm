package exam.pdd.D2018;

import java.util.Scanner;

public class class1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            int offset  = sc.nextInt();
            int num = sc.nextInt();
            int len1 = sc.nextInt();
            int len2 = sc.nextInt();
            int start1 = 0,end1 = 0,start2 = 0,end2=0;
            if(offset<len1&&offset+num<len1){
                start1 = offset;
                end1 = offset+num;
                start2 = 0;
                end2 = 0;
            }else if(offset<len1&&offset+num>=len1&&offset+num<len1+len2){
                start1 = offset;
                end1 = len1;
                start2 = 0;
                end2 = num+offset-len1;
            }else if(offset<len1&&offset+num>=len1+len2){
                start1 = offset;
                end1 = len1;
                start2 = 0;
                end2= len2;
            }else if(offset>=len1&&offset<len1+len2&&offset+num>=len1&&offset+num<len1+len2){
                start1 = len1;
                end1 = len1;
                start2 = offset-len1;
                end2 = start2+num;
            }else if(offset>=len1&&offset<len1+len2&&offset+num>=len1+len2){
                start1 = len1;
                end1 = len1;
                start2 = offset-len1;
                end2 = len2;
            }else if(offset>=len1+len2){
                start1 = end1 = len1;
                start2 = end2 = len2;
            }
            System.out.println(start1+" "+end1+" "+start2+" "+end2);
        }
    }

}
