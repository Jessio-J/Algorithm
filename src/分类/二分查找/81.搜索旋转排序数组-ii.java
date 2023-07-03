/*
 * @lc app=leetcode.cn id=81 lang=java
 *
 * [81] 搜索旋转排序数组 II
 */

// @lc code=start

import java.util.Arrays;

class Solution {

    public boolean search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return false;
        }
        return partSearch(nums,0,nums.length-1,target);
    }
    private boolean partSearch(int[] nums, int l, int r,int target) {
        if (l == r) {
            if(nums[l]!=target){
                return false;
            }else {
                return true;
            }

        }else {
            int mid = (l + r)/2;
            if(nums[mid]==nums[l]&&nums[mid]==nums[r]){
                return findInLine(nums,l,r,target);
            }else {
                if(nums[mid]==target){
                    return true;
                }else if(nums[l]<=target&&target<nums[mid]||nums[l]>nums[mid]&&(nums[l]<=target||target<=nums[mid])){
                    //1.左<=target<=右
                    //(旋转点)2.左>mid 同时 target<左 target<mid
                    return partSearch(nums,l,mid,target);
                }else if(nums[mid]<target&&target<=nums[r]||nums[r]<nums[mid]&&(nums[mid]<=target||target<=nums[r])){
                    //1.中<=target<=右
                    //(旋转点)2.右<mid 同时 target<右 target<mid
                    return partSearch(nums,mid+1,r,target);
                }
            }
        }
        return false;
    }
    private boolean findInLine(int[] nums,int l,int r,int target){
        for(int i = l;i<=r;i++){
            if(nums[i]==target){
                return true;
            }
        }
        return false;
    }

}
// @lc code=end
