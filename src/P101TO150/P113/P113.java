package P101TO150.P113;

import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P113 {
    List<List<Integer>> rList = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null){
            return new ArrayList<>();
        }
        find(root,new ArrayList<>(),sum,0);
        return rList;

    }
    private void find(TreeNode root,List<Integer> list,int target,int cur){
        cur += root.val;
        list.add(root.val);
        boolean isLeaf = root.left==null&&root.right==null;
        if(cur==target&&isLeaf){
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.addAll(list);
            rList.add(tmp);
        }
        if(root.left!=null){
            find(root.left,list,target,cur);
        }
        if(root.right!=null){
            find(root.right,list,target,cur);
        }
        cur -= root.val;
        list.remove(list.size()-1);
    }
}
