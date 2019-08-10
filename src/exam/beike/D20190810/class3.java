package exam.beike.D20190810;

import java.util.Arrays;
import java.util.Scanner;

public class class3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] wi = new int[n];
        for (int i = 0; i < wi.length; i++) {
            wi[i] = sc.nextInt();
        }
        int result = check(wi);
        System.out.println(result);
    }
    public static int check(int[] wi){
        int n = wi.length;
        int count = 0;
        Arrays.sort(wi);
        for(int i = 0;i<n;i++){
            for (int j = i+1;j<n;j++){
                if(wi[i]>=0.9*wi[j]){
                    count++;
                }else {
                    break;
                }
            }
        }
        return count;
    }
}
