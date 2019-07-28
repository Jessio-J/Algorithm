package exam.pdd.D20190728;

import java.util.Scanner;

public class class1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tmpstr = sc.nextLine();
        String[] tmpstrarr = tmpstr.trim().split(" ");
        int[] nums = new int[tmpstrarr.length];
        for(int i = 0;i<tmpstrarr.length;i++){
            nums[i] = Integer.parseInt(tmpstrarr[i]);
        }
        String tmpstr2 = sc.nextLine();
        String[] tmpstrarr2 = tmpstr2.trim().split(" ");
        int[] nums2 = new int[tmpstrarr2.length];
        for(int i = 0;i<tmpstrarr2.length;i++){
            nums2[i] = Integer.parseInt(tmpstrarr2[i]);
        }
        if(nums.length==1){
            System.out.print(nums[0]);
            return;
        }

        int a = 1;
        int low = 0;
        int high = 0;
        for (; a < nums.length; a++) {
            if(nums[a]<=nums[a-1]){
                low = nums[a-1];
                break;
            }
        }
        if(a!=nums.length-1){
            high = nums[a+1];
        }else {
            high = Integer.MAX_VALUE;
        }

        int result = Integer.MIN_VALUE;
        for (int b = 0; b < nums2.length; b++) {
            if(nums2[b]>low&&nums2[b]<high&&result<nums2[b]){
                result = nums2[b];
            }
        }
        if(result!=Integer.MIN_VALUE){
            nums[a] = result;
            for (int i = 0; i < nums.length-1; i++) {
                System.out.print(nums[i]+" ");
            }
            System.out.print(nums[nums.length-1]);
        }else {
            if(a-1==0){
                low = Integer.MIN_VALUE;
                high = nums[a];
            }else {
                low = nums[a-2];
                high = nums[a];
            }
            for (int b = 0; b < nums2.length; b++) {
                if(nums2[b]>low&&nums2[b]<high&&result<nums2[b]){
                    result = nums2[b];
                }
            }
            if(result!=Integer.MIN_VALUE){
                nums[a-1] = result;
                for (int i = 0; i < nums.length-1; i++) {
                    System.out.print(nums[i]+" ");
                }
                System.out.print(nums[nums.length-1]);
            }else
            System.out.println("NO");
        }

    }
}
