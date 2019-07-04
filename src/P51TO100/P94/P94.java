package P51TO100.P94;

import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P94 {
    List<Integer> rList = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return rList;
        }
        midOrder(root);
        return rList;
    }
    private void midOrder(TreeNode root){
        if(root!=null){
            midOrder(root.left);
            rList.add(root.val);
            midOrder(root.right);
        }
    }
}
