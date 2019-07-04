package jianzhiOffer.P55;

import datastruct.TreeNode;

public class P55_2 {
    boolean flag = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        getTreeHeight(root);
        return flag;
    }
    private int getTreeHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        int l = getTreeHeight(root.left);
        int r = getTreeHeight(root.right);
        if(Math.abs(l-r)>1){
            flag = false;
        }
        if(l>r){
            return l+1;
        }else {
            return r+1;
        }
    }
}
