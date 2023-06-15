/*
 * @lc app=leetcode.cn id=1431 lang=java
 *
 * [1431] 拥有最多糖果的孩子
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        List<Boolean> result = new ArrayList<>();
        for (int i : candies) {
            if(i>=max){
                max = i;
            }
        }
        for (int i : candies) {
            if(i+extraCandies>=max){
                result.add(new Boolean(true));
            }else{
                result.add(new Boolean(false));
            }
        }
        return result;
    }
}
// @lc code=end

