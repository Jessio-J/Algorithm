package jianzhiOffer.P27;

import datastruct.TreeNode;

public class P27 {
    public void Mirror(TreeNode root) {
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            return;
        }
        TreeNode p = root.left;
        root.left = root.right;
        root.right = p;
        if (root.left!=null){
            Mirror(root.left);
        }
        if(root.right!=null){
            Mirror(root.right);
        }
    }
}
