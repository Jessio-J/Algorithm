package exam.beike.D20190810;

import java.util.Scanner;

public class class4_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i = 0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        long res =Long.MAX_VALUE;
        for(int top =0;top<n;top++){
            long count = 0;
            int left = nums[0];
            for(int i = 1;i<=top;i++){
                if(left+1<nums[i]){
                    left= nums[i];
                }
                else{
                    left++;
                }
                count+=left-nums[i];
            }
            int right = nums[n-1];
            for(int i = n-2;i>=top;i--){
                if(right+1<nums[i]){
                    right= nums[i];
                }
                else {
                    right++;
                }
                count+=right-nums[i];
            }
            if(left>right){
                count-=right-nums[top];
            }
            else {
                count-=left-nums[top];
            }
            if(res>count)res = count;
        }
        System.out.println(res);
    }
}
