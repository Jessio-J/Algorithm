package P51TO100.P55;
//贪心算法
public class P55_JumpGame3 {
    public boolean canJump(int[] nums){
        // max_len代表当前可达最大的长度
        int max_len = 0;
        for(int i=0; i<nums.length; i++){
            //遍历的长度小于等于当前最大长度，则继续，否则代表该i不可达
            if(i<=max_len){
                //当前最大长度取，与遍历长度加节点可达长度之和，两者取较大值
                max_len = Math.max(max_len, i+nums[i]);
            }else{
                return false;
            }
        }
        return true;
    }
}
