package P101TO150.P114;

import datastruct.TreeNode;

public class P114 {
    public void flatten(TreeNode root) {
        convertNode(root,null);
        return;
    }

    private TreeNode convertNode(TreeNode node,TreeNode lastNode){
        if(node==null){
            return null;
        }
        TreeNode cur = node;
        TreeNode curl = node.left;
        TreeNode curr = node.right;
        cur.left = null;
        if(lastNode!=null){
            lastNode.right=cur;
        }
        lastNode = cur;
        if(curl!=null){
            lastNode = convertNode(curl,lastNode);
        }
        if(curr!=null){
            lastNode = convertNode(curr,lastNode);
        }
        return lastNode;
    }
}
