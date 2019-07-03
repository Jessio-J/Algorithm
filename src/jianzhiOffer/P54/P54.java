package jianzhiOffer.P54;

import datastruct.TreeNode;

public class P54 {
    int count = 0;
    TreeNode KthNode(TreeNode pRoot, int k) {
        return inOrder(pRoot,k);
    }
    private TreeNode inOrder(TreeNode node,int k){
        TreeNode rnode = null;
        if(node!=null&&count<k){
            if((rnode = inOrder(node.left,k))!=null){
                return rnode;
            }

            if(++count==k){
                return node;
            }
            if((rnode = inOrder(node.right,k))!=null){
                return rnode;
            }
        }
        return rnode;
    }
}
