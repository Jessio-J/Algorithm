package P34;
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
//        你的算法时间复杂度必须是 O(log n) 级别。
//
//        如果数组中不存在目标值，返回 [-1, -1]。
//
//        示例 1:
//
//        输入: nums = [5,7,7,8,8,10], target = 8
//        输出: [3,4]
//        示例 2:
//
//        输入: nums = [5,7,7,8,8,10], target = 6
//        输出: [-1,-1]

public class P34_FindFirstAndLast {
    public int[] searchRange(int[] nums, int target) {
        int[] rt = new int[]{-1,-1};
        if(nums==null||nums.length==0){
            return rt;
        }
        partSearch(nums,0,nums.length-1,target,rt,0);
        return rt;
    }
    private void partSearch(int[] nums, int l, int r,int target,int[] index,int flag) {

        if (l == r) {
            if(nums[l]==target){
                if(flag == 1){
                    index[0] = l;
                }else if(flag == 2){
                    index[1] = l;
                }else if(flag == 0){
                    index[0] = l;
                    index[1] = l;
                }
            }

        }else {
            int mid = (l + r)/2;
            if(nums[mid]<target) {
                partSearch(nums, mid + 1, r, target,index,flag);
            }else if(nums[mid]>target){
                partSearch(nums,l,mid,target,index,flag);
            }else if(nums[mid]==target){
                if(flag == 1){
                    index[0] = mid;
                    partSearch(nums,l,mid,target,index,1);
                }else if(flag == 2){
                    index[1] = mid;
                    partSearch(nums,mid+1,r,target,index,2);
                }else if(flag == 0){
                    index[0] = mid;
                    index[1] = mid;
                    partSearch(nums,l,mid,target,index,1);
                    partSearch(nums,mid+1,r,target,index,2);
                }
            }
        }
    }
}
