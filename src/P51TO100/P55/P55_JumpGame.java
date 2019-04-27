package P51TO100.P55;
//给定一个非负整数数组，你最初位于数组的第一个位置。
//
//        数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//        判断你是否能够到达最后一个位置。
//
//        示例 1:
//
//        输入: [2,3,1,1,4]
//        输出: true
//        解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
//        示例 2:
//
//        输入: [3,2,1,0,4]
//        输出: false
//        解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
//此解法超出时间限制
//超出时间限制
public class P55_JumpGame {
    boolean flag = false;
    public boolean canJump(int[] nums) {
         check(nums,0);
         return flag;
    }
    private void check(int[] nums,int index){
        if(index >=nums.length-1){
            flag = true;
            return;
        }else {
            for(int i =nums[index];i>0;i--){
                if(flag ==true){
                    return;
                }
                check(nums,index+i);
            }
        }
    }
}
