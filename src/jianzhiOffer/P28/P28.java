package jianzhiOffer.P28;

import datastruct.TreeNode;

public class P28 {
    boolean isSymmetrical(TreeNode pRoot) {
        return check(pRoot,pRoot);
    }
    private boolean check(TreeNode p1,TreeNode p2){
        if(p1==null&&p2==null){
            return true;
        }
        if(p1==null||p2==null){
            return false;
        }
        if(p1.val!=p2.val){
            return false;
        }
        return check(p1.left,p2.right)&&check(p1.right,p2.left);
    }
}
