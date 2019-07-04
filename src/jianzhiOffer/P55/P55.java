package jianzhiOffer.P55;

import datastruct.TreeNode;

public class P55 {
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = TreeDepth(root.left);
        int r = TreeDepth(root.right);
        if (l > r) {
            return l + 1;
        } else {
            return r + 1;
        }
    }
}
