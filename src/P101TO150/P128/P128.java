package P101TO150.P128;

import java.util.HashMap;

public class P128 {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> hash_dict = new HashMap<Integer,Integer>();
        int max_length = 0;
        for(int i =0;i<nums.length;i++){
            if(!hash_dict.containsKey(nums[i])){
                int left = hash_dict.get(nums[i]-1)==null?0:hash_dict.get(nums[i]-1);
                int right = hash_dict.get(nums[i]+1)==null?0:hash_dict.get(nums[i]+1);
                int cur_length = 1 + left + right;
                if(cur_length>max_length)
                    max_length = cur_length;
                hash_dict.put(nums[i],cur_length);
                //只修改边界上的值,因为每次也只是在边界上读取这些值
                hash_dict.put(nums[i]-left,cur_length);
                //只修改边界上的值
                hash_dict.put(nums[i]+right,cur_length);
            }
        }
        return max_length;
    }
}
