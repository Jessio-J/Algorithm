package P51TO100.P60;

public class P60_PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for(int i = 0;i<n;i++){
            nums[i] = i+1;
        }
        for(int i=1;i<k;i++){
            nextPermutation(nums);
        }
        StringBuilder s = new StringBuilder();
        for(int i = 0;i<n;i++){
            s.append(nums[i]);
        }
        return s.toString();
    }
    private void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
