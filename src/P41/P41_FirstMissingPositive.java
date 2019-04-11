package P41;
//
//给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
//
//        示例 1:
//
//        输入: [1,2,0]
//        输出: 3
//        示例 2:
//
//        输入: [3,4,-1,1]
//        输出: 2
//        示例 3:
//
//        输入: [7,8,9,11,12]
//        输出: 1

//说明:
//
//        你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。

public class P41_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int temp;
        int temp2;
        boolean flag = false;
        if (nums == null || nums.length == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==nums.length){
                flag = true;
            }
            if (nums[i] > 0 && nums[i] < nums.length && nums[i] != i) {
                temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                while (temp > 0 && temp < nums.length && nums[temp] != temp) {
                    temp2 = nums[temp];
                    nums[temp] = temp;
                    temp = temp2;
                }
                if(temp==nums.length){
                    flag = true;
                }
            }
        }
        int i = 1;
        while (i < nums.length) {
            if (nums[i] != i) {
                return i;
            }
            i++;
        }
        if (!flag) {
            return i;
        } else {
            return i + 1;
        }
    }
}
