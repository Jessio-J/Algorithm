package P101TO150.P129;

import datastruct.TreeNode;

public class P129 {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        preOrder(root,0);
        return sum;
    }

    public void preOrder(TreeNode root,int tmpSum) {
        if(root!=null) {
            tmpSum = tmpSum*10+root.val;
            if(root.left==null&&root.right==null){
                sum += tmpSum;
            }else{
                preOrder(root.left,tmpSum);
                preOrder(root.right,tmpSum);
            }

        }
    }
}
