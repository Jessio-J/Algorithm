package jianzhiOffer.P34;

import datastruct.TreeNode;

import java.util.ArrayList;

public class P34 {
    ArrayList<ArrayList<Integer>> rList = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root==null){
            return new ArrayList<>();
        }
        find(root,new ArrayList<>(),target,0);
        return rList;

    }
    private void find(TreeNode root,ArrayList<Integer> list,int target,int cur){
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
