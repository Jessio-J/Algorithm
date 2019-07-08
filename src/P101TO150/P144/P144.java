package P101TO150.P144;

import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;
//前序遍历递归方法
public class P144 {
    List<Integer> rList = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return rList;

    }
    private void preOrder(TreeNode node){
        if(node!=null){

            preOrder(node.left);
            preOrder(node.right);
            rList.add(node.val);
        }
    }
}
