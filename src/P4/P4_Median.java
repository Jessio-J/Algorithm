package P4;

//给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
//
//        请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
//
//        你可以假设 nums1 和 nums2 不会同时为空。
//
//        示例 1:
//
//        nums1 = [1, 3]
//        nums2 = [2]
//
//        则中位数是 2.0
//        示例 2:
//
//        nums1 = [1, 2]
//        nums2 = [3, 4]
//
//        则中位数是 (2 + 3)/2 = 2.5
public class P4_Median {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0d;
        int flag = (nums1.length+nums2.length)%2==0?1:0;
        int mIndex = (nums1.length+nums2.length)/2+1;
        int[] nums = new int[mIndex];
        int j =0,k =0;
        for(int i = 0;i<mIndex;i++){
            if(k<nums2.length &&j<nums1.length &&nums1[j]>nums2[k]||j>=nums1.length&&k<nums2.length){
                nums[i] = nums2[k];
                k++;
            }else if(k<nums2.length && j<nums1.length && nums1[j]<=nums2[k]||k>=nums2.length&&j<nums1.length){
                nums[i] = nums1[j];
                j++;
            }
        }
        if(flag==0){
            //中位数为1个
            median = nums[mIndex-1];
        }else {
            //中位数为2个数平均值
            median = (nums[mIndex-1] + nums[mIndex-2])/2.0;
        }
        return median;
    }
    public static void main(String[] args){
        System.out.println(""+new P4_Median().findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
    }
}
