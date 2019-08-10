package exam.beike.D20190810;

import java.util.Scanner;

public class class1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }
        if(n<2){
            return;
        }
        long min = Long.MAX_VALUE;
        long num1 = 0;
        long num2 = 0;
        for (int i = 0; i < nums.length-1; i++) {
            long result = Math.abs(nums[i]-nums[i+1]);
            if(result<min){
                num1 = nums[i];
                num2 = nums[i+1];
                min = result;
            }

        }
        System.out.println(num1+" "+num2);
    }
}
