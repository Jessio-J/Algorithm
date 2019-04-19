package P1TO50.P33;

public class P33_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return -1;
        }
        return partSearch(nums,0,nums.length-1,target);
    }
    private int partSearch(int[] nums, int l, int r,int target) {
        if (l == r) {
            if(nums[l]!=target){
                return -1;
            }else {
                return l;
            }

        }else {
            int mid = (l + r)/2;
            if(nums[mid]==target){
                return  mid;
            }else if(nums[l]<=target&&target<nums[mid]||nums[l]>nums[mid]&&(nums[l]<=target||target<=nums[mid])){
                return partSearch(nums,l,mid,target);
            }else if(nums[mid]<target&&target<=nums[r]||nums[r]<nums[mid]&&(nums[mid]<=target||target<=nums[r])){
                return partSearch(nums,mid+1,r,target);
            }
        }
        return -1;
    }
}
