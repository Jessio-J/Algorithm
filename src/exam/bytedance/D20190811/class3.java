package exam.bytedance.D20190811;

import java.util.Scanner;

public class class3 {
    static int sum=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int add = 100;
        int[] years = new int[N];
        int min = Integer.MIN_VALUE;
        int id= 0;
        for (int i = 0; i < years.length; i++) {
            years[i] = sc.nextInt();
            if(years[i]<min){
                min = years[i];
                id = i;
            }

        }
        if(N==1){
            System.out.print("100");
            return;
        }
        for(int i = id;i>=0;i--){
            if(i==id||years[i]<years[i+1]){
                add = 100;
            }
            if(years[i]>years[i+1]){
                add+=100;
            }
            sum+=add;
        }
        for(int i = id+1;i<N;i++){
            if(years[i]>years[i-1]){
                add += 100;
            }
            if(years[i]<years[i-1]){
                add=100;
            }
            sum+=add;
        }
        System.out.println(sum);
    }
}
