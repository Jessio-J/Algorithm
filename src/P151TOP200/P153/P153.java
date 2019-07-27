package P151TOP200.P153;

public class P153 {
    //相当于找到旋转点
    public int findMin(int[] nums) {
        if(nums.length==0){
            return 0;
        }else {
            return find(nums,0,nums.length-1);
        }
    }
    private int find(int[] nums,int l,int r){
        if(l==r){
            return nums[l];
        }else {
            int mid = (l+r)>>1;
            if(nums[l]>nums[mid]){
                return find(nums,l,mid);
            }else if(nums[mid]>nums[r]){
                return find(nums,mid+1,r);
            }else if(nums[l]<=nums[mid]&&nums[mid]<=nums[r]){
                return nums[l];
            }
        }
        return 0;
    }
}
