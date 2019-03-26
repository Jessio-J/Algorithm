package P30;

import java.util.Arrays;
//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
//        如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
//        必须原地修改，只允许使用额外常数空间。
//
//        以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
//        1,2,3 → 1,3,2
//        3,2,1 → 1,2,3
//        1,1,5 → 1,5,1
public class P30_NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length-1;
        while(i-1>=0&&nums[i-1]>=nums[i]){
            i--;
        }
        if(i==0){
            Arrays.sort(nums);
            return ;
        }else {
            int cur = nums[i-1];
            int min = nums[i];
            int minIndex = i;
            for(int j = i+1;j<nums.length;j++){
                if(nums[j]<min&&nums[j]>cur){
                    min = nums[j];
                    minIndex = j;
                }
            }
            swap(nums,minIndex,i-1);
            Arrays.sort(nums,i,nums.length);
            return ;
        }
    }
    private void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
