package exam.beike.D20190810;

import java.util.Scanner;

public class class4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums[i];
        }
        int i = 0;
        while (i<n-1){
            if(nums[i]>=nums[i+1]){
                break;
            }else {
                i++;
            }
        }
        int j = n-1;
        while (j>0){
            if(nums[j]>=nums[j-1]){
                break;
            }else {
                j--;
            }
        }
        if(i==n-1||j==0||i+1==j){
            System.out.println("0");
            return;
        }
        int sum = 0;
        while (i+1<j-1){
            sum += (nums[i]+1-nums[i+1]);
            sum += (nums[j]+1-nums[j-1]);
            nums[i+1] = nums[i]+1;
            nums[j-1] = nums[j]+1;
            i++;
            j++;
        }
        if(i+1==j){
            System.out.println(sum);
            return;
        }else if(i+1==j-1){
            sum+=Math.min(nums[i]+1,nums[j]+1);
            System.out.println(sum);
            return;
        }

    }
}
