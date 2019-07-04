package jianzhiOffer.P26;

import datastruct.TreeNode;

//输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
public class P26 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if(root1!=null&&root2!=null){
            if(root1.val==root2.val){
                result = DoesT1HaveT2(root1,root2);
            }
            if(!result){
                result = HasSubtree(root1.left,root2);
            }
            if(!result){
                result = HasSubtree(root1.right,root2);
            }
        }
        return result;
    }
    private boolean DoesT1HaveT2(TreeNode t1,TreeNode t2){
        if(t2==null){
            return true;
        }
        if(t1==null){
            return false;
        }
        if(t1.val!=t2.val){
            return false;
        }
        return DoesT1HaveT2(t1.left,t2.left)&&DoesT1HaveT2(t1.right,t2.right);
    }
}
