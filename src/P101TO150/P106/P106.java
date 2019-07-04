package P101TO150.P106;

import datastruct.TreeNode;

import java.util.Arrays;

public class P106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0||inorder.length == 0){
            return null;
        }
        TreeNode node = new TreeNode(postorder[postorder.length-1]);
        for(int i = 0; i < inorder.length; i++){
            if(postorder[postorder.length-1] == inorder[i]){
                node.left = buildTree(Arrays.copyOfRange(inorder, 0, i),Arrays.copyOfRange(postorder, 0, i));
                node.right = buildTree( Arrays.copyOfRange(inorder, i+1,inorder.length),Arrays.copyOfRange(postorder, i, postorder.length-1));
            }
        }
        return node;
    }
}
