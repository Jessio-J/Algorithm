package P51TO100.P55;
//越过为0的数
public class P55_JumpGame2   {
    public boolean canJump(int[] nums) {
        if(nums.length==0){
            return false;
        }else if(nums.length==1){
            return true;
        }else if(nums.length>1&&nums[0]==0){
            return false;
        }
        for(int i = nums.length-2;i>0;i--){
            if(nums[i]==0){
                if(check(nums,i)){
                    continue;
                }else {
                    return false;
                }
            }else {
                continue;
            }
        }
        return true;
    }
    private boolean check(int[] nums,int index){
        int init = index;
        index --;
        while(index>=0){
            if(nums[index]>init - index){
                return true;
            }
            index--;
        }
        return false;
    }
}
