package P51TO100.P81;

public class P81 {

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
                    return partSearch(nums,l,mid,target);
                }else if(nums[mid]<target&&target<=nums[r]||nums[r]<nums[mid]&&(nums[mid]<=target||target<=nums[r])){
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
