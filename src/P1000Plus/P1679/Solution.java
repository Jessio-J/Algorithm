package P1000Plus.P1679;

import java.util.Arrays;
/*
 * @lc app=leetcode.cn id=1679 lang=java
 *
 * [1679] K 和数对的最大数目
 */

// @lc code=start
public class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        // quickSort(nums, 0, nums.length - 1);
        int l = 0;
        int r = nums.length - 1;
        int result = 0;
        while (l < r) {
            if (nums[l] + nums[r] == k) {
                result++;
                l++;
                r--;
            }else if(nums[l] + nums[r] < k){
                l++;
            }else {
                r--;
            }
        }

        return result;
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int index = partition(nums, l, r);
            quickSort(nums, l, index - 1);
            quickSort(nums, index + 1, r);
        }

    }

    private int partition(int[] nums, int left, int right) {
        int p = left;
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (nums[i] < nums[p]) {
                swap(nums, index++, i);
            }
        }
        swap(nums, index - 1, p);
        return index - 1;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}

// @lc code=end