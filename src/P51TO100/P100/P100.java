package P51TO100.P100;

import datastruct.TreeNode;

public class P100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q!=null||p!=null&&q==null){
            return false;
        }else if(p==null&&q==null){
            return true;
        }
        if(p.val==q.val){
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }else {
            return false;
        }
    }
}
