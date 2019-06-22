package jianzhiOffer.P38;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P38 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> rList = new ArrayList();
        if(str==null||str.equals("")){
            return new ArrayList<>();
        }
        char[] strarr = str.toCharArray();
        Arrays.sort(strarr);
        dfs(rList,strarr,0);
        return rList;
    }
    private void dfs(ArrayList<String> res, char[] nums, int cur) {
        char[] newNums = Arrays.copyOf(nums, nums.length);
        if (cur == newNums.length) {
            String nstr = new String(newNums);
            res.add(nstr);
        } else{
            for (int i = cur; i < newNums.length; i++) {
                if (cur != i && newNums[i] == newNums[cur]) continue; //去重
                swap(newNums, cur, i);
                dfs(res, newNums, cur + 1);
//            swap(newNums,cur,i); //不能交换 不然也不能去重
            }
        }
    }
    private void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
