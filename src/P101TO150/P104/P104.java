package P101TO150.P104;

import datastruct.TreeNode;
//求树高
public class P104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if (l > r) {
            return l + 1;
        } else {
            return r + 1;
        }
    }
}
