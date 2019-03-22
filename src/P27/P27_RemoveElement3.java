package P27;
//思路：首尾指针法，思路同1，其实没有必要像算法1中去做交换，只需要把右指针的值赋值给左指针就行。
public class P27_RemoveElement3 {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

}
