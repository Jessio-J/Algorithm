package P101TO150.P136;

public class P136 {
    public int singleNumber(int[] nums) {
        for(int i = 1;i<nums.length;i++){
            nums[i] = nums[i]^nums[i-1];
        }
        return nums[nums.length-1];
    }
}
