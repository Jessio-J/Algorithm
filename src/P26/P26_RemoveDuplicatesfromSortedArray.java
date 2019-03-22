package P26;

public class P26_RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int len = nums.length;
        int[] index = new int[nums.length];
        int cur = nums[0];
        index[0]=0;
        int j = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==cur){
                len--;
            }else {
                cur = nums[i];
                index[j] = i;
                j++;
            }
        }
        for(int k = 1;k < j;k++){
            nums[k] = nums[index[k]];
        }
        return len;
    }
}
