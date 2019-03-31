package P35;
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
//        你可以假设数组中无重复元素。
//
//        示例 1:
//
//        输入: [1,3,5,6], 5
//        输出: 2
//        示例 2:
//
//        输入: [1,3,5,6], 2
//        输出: 1
//        示例 3:
//
//        输入: [1,3,5,6], 7
//        输出: 4
//        示例 4:
//
//        输入: [1,3,5,6], 0
//        输出: 0
public class P35_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return 0;
        }
        return partSearch(nums,0,nums.length-1,target);
    }
    private int partSearch(int[] nums, int l, int r,int target) {
        if (l == r) {
            if(nums[l]<target){
                return l+1;
            }else {
                return l;
            }
        }else {
            int mid = (l + r)/2;
            if(nums[mid]>target){
                return partSearch(nums,l,mid,target);
            }else if(nums[mid]<target){
                return partSearch(nums,mid+1,r,target);
            }else{
                return mid;
            }
        }
    }
}
