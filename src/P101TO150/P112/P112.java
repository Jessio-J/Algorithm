package P101TO150.P112;

import datastruct.TreeNode;

public class P112 {
    boolean flag = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        find(root,0,sum);
        return flag;
    }
    private void find(TreeNode node,int sum,int target){
        if(!flag){
            if(node!=null){
                sum += node.val;
                if(node.left==null&&node.right==null&&sum==target){
                    flag = true;
                    return;
                }
                find(node.left,sum,target);
                find(node.right,sum,target);
            }
        }

    }
}
