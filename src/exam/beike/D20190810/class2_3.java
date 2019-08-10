package exam.beike.D20190810;

import java.util.Scanner;

public class class2_3 {
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
        lis(nums,n);
        System.out.println(maxIndex);

    }
    public static int maxIndex = 1;
    public static int lis(long[] arr,int index){
        if(index==1)return 1;
        int res,longest = 1;
        for(int i = 1;i<index;i++){
            res = lis(arr,i);
            if(arr[i-1]<arr[index-1]&&res+1>longest){
                longest=res+1;
            }
        }
        if(maxIndex<longest){
            maxIndex = longest;
        }
        return longest;
    }
}
