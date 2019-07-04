package P51TO100.P74;
//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//
//        每行中的整数从左到右按升序排列。
//        每行的第一个整数大于前一行的最后一个整数。
//        示例 1:
//
//        输入:
//        matrix = [
//        [1,   3,  5,  7],
//        [10, 11, 16, 20],
//        [23, 30, 34, 50]
//        ]
//        target = 3
//        输出: true
public class P74_Searcha2DMatrix {
    boolean flag = false;
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }else {
            partSearch(matrix,0,matrix.length-1,target);
        }
        return flag;
    }
    private void partSearch(int[][] nums, int top, int bot,int target) {
        if (top == bot) {
            if(nums[top][0]>target||nums[top][nums[top].length-1]<target){
                return;
            }else {
                partSearch2(nums[top],0,nums[top].length-1,target);
            }

        }else {
            int mid = (top + bot)>>1;
            if(nums[mid][nums[mid].length-1]>=target){
                partSearch(nums,top,mid,target);
            }else {
                partSearch(nums,mid+1,bot,target);
            }
        }
    }
    private void partSearch2(int[] nums, int l, int r,int target) {
        if (l == r) {
            if(nums[l] == target){
                flag = true;
            }else {
                return;
            }

        }else {
            int mid = (l + r)>>1;
            if(nums[mid]>=target){
                partSearch2(nums,l,mid,target);
            }else {
                partSearch2(nums,mid+1,r,target);
            }
        }
    }
}
