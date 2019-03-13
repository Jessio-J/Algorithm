package P15;

import java.util.*;
//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
//
//        注意：答案中不可以包含重复的三元组。
//
//        例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//        满足要求的三元组集合为：
//        [
//        [-1, 0, 1],
//        [-1, -1, 2]
//        ]
public class P15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rlist = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        int[] array = {nums[i],nums[j],nums[k]};
                        Arrays.sort(array);
                        if(map.get(array[0]+","+array[1])==null||map.get(array[0]+","+array[1]).equals("")){
                            map.put(array[0]+","+array[1],"1");
                            List<Integer> l = new ArrayList<>();
                            l.add(nums[i]);
                            l.add(nums[j]);
                            l.add(nums[k]);
                            rlist.add(l);
                        }else {
                            continue;
                        }

                    }
                }
            }
        }
        return rlist;
    }
}
