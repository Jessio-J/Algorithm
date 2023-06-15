/*
 * @lc app=leetcode.cn id=605 lang=java
 *
 * [605] 种花问题
 */

// @lc code=start
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
       for (int i = 0;i<flowerbed.length && n>0;){
        if(flowerbed[i]==1){
            i +=2;
        }else if(i==flowerbed.length-1||flowerbed[i+1]==0){
            n--;
            i+=2;
        }else if(flowerbed[i+1]==1){
            i+=3;
        }
       }
       return n<=0;
    }
}
// @lc code=end
