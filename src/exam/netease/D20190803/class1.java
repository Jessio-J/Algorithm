package exam.netease.D20190803;

import java.text.NumberFormat;

import java.util.Scanner;

public class class1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
             a[i] = scanner.nextInt();

        }
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            System.out.println(perC(a,scanner.nextInt()));
        }
    }

    public static String perC(int[] a,int b) {
        int l = a.length;
        int c = 0;
        int i = 0;
        while (i<l){
            if(a[b-1]>=a[i])c++;
            i++;
        }
        if(c==0){
            return "0.000000";
        }
        NumberFormat df = NumberFormat.getCurrencyInstance();
        df.setMinimumFractionDigits(6);
        double result=100.0*(c-1)/l;
        return df.format(result);

    }
}
