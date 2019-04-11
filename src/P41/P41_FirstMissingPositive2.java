package P41;

public class P41_FirstMissingPositive2 {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0  && nums[i] < nums.length && nums[nums[i]-1] != nums[i]) {
                swap(nums, i, nums[i]-1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) return i+1;
        }
        return nums.length+1;
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
