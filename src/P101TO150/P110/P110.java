package P101TO150.P110;

import datastruct.TreeNode;

public class P110 {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        depth(root);
        return flag;
    }
    public int depth(TreeNode Node) {
        if (Node == null) {
            return 0;
        }
        int l = depth(Node.left);
        int r = depth(Node.right);
        if(l-r>1||r-l>1){
            flag = false;
        }
        if (l > r) {
            return l + 1;
        } else {
            return r + 1;
        }

    }
}
