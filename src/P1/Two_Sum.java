package P1;

/**
 * 题目：给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 时间：2019-1-16 20:44:28
 */
public class Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        for(int indexi = 0;indexi <nums.length-1;indexi++){
            int rest = target - nums[indexi];
            for (int indexj = indexi+1;indexj <nums.length;indexj++){
                if(nums[indexj] == rest){
                    return new int[]{indexi,indexj};
                }
            }
        }
        return new int[]{};
    }
    public static void main(String[] args){
        Two_Sum ts = new Two_Sum();
        int[] rs = ts.twoSum(new int[]{3,2,4},6);
        System.out.println("["+rs[0]+","+rs[1]+"]");
    }
    /**
     * 其他解法
     * 方法三：一遍哈希表
     * 事实证明，我们可以一次完成。在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。如果它存在，那我们已经找到了对应解，并立即将其返回。
     */
//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];
//            if (map.containsKey(complement)) {
//                return new int[] { map.get(complement), i };
//            }
//            map.put(nums[i], i);
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }
}
