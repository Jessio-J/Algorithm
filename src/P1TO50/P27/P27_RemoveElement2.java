package P1TO50.P27;
//思路：快慢指针法，j是顺序遍历的快指针，i是慢指针，当nums[ j ] !=val 时，把nums[ j ] 赋值给nums[ i ],直到完成遍历。
public class P27_RemoveElement2 {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
