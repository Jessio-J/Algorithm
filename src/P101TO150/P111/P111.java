package P101TO150.P111;

import datastruct.TreeNode;

public class P111 {
    int minHeight = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        preOrder(root,0);
        return minHeight;
    }
    public void preOrder(TreeNode Node,int level)
    {
        if (Node != null)
        {
            level++;
            if(Node.left==null&&Node.right==null&&level<minHeight){
                minHeight = level;
            }
            preOrder(Node.left,level);
            preOrder(Node.right,level);
        }
    }
}
