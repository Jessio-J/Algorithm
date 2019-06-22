package P101TO150.P105;

import datastruct.TreeNode;

import java.util.Arrays;

public class P105 {
    public TreeNode buildTree(int [] preorder, int [] inorder) {
        if(preorder.length == 0||inorder.length == 0){
            return null;
        }
        TreeNode node = new TreeNode(preorder[0]);
        for(int i = 0; i < inorder.length; i++){
            if(preorder[0] == inorder[i]){
                node.left = buildTree(Arrays.copyOfRange(preorder, 1, i+1), Arrays.copyOfRange(inorder, 0, i));
                node.right = buildTree(Arrays.copyOfRange(preorder, i+1, preorder.length), Arrays.copyOfRange(inorder, i+1,inorder.length));
            }
        }
        return node;
    }
}
