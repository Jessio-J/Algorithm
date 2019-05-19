package P51TO100.P77;

import java.util.ArrayList;
import java.util.List;
//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
//        示例:
//
//        输入: n = 4, k = 2
//        输出:
//        [
//        [2,4],
//        [3,4],
//        [2,3],
//        [1,2],
//        [1,3],
//        [1,4],
//        ]
public class P77 {
    List<List<Integer>> rList = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if(n<=0||k>n){
            return rList;
        }
        partCombine(n,k,0,new ArrayList<>(),0);
        return rList;
    }
    private void partCombine(int n,int k,int index,List<Integer> curList,int level){
        if(level == k){
            List<Integer> tmpList = new ArrayList<>();
            tmpList.addAll(curList);
            rList.add(tmpList);
        }else if(level<k){
            for(int i = index+1;i<=n-(k-level-1);i++){
                curList.add(i);
                partCombine(n,k,i,curList,level+1);
                curList.remove(curList.size()-1);
            }
        }
    }
}
