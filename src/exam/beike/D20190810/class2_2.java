package exam.beike.D20190810;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class class2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] nums = new long[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextLong();
        }
        if(nums.length==0||nums==null){
            System.out.println("0");
            return;
        }
        int len = nums.length;
        int gratest[] = new int[len];
        gratest[0] = 1;
        int l = 1;
        for (int i = 1; i < len; i++) {
            int newlong = 0;
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i]){
                    newlong = Math.max(gratest[j],newlong);
                }

            }
            gratest[i] = newlong +1;
            l = Math.max(gratest[i],l);
        }
        System.out.println(""+l);
    }
}
