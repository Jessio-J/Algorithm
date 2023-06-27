package datastruct;

import java.util.LinkedList;
import java.util.Queue;
//层次遍历数组，创建二叉树
public class BuildTree {
    static int index = 0;

    public static void main(String[] args) {
        Integer[] levelOrder = {1, 2, 3, null, 4};
        TreeNode root = buildTree(levelOrder);
        // 然后可以对 root 进行操作
    }

    public static TreeNode buildTree(Integer[] levelOrder) {
        if (levelOrder.length == 0 || levelOrder[0] == null) {
            return null;
        }
        TreeNode root = new TreeNode(levelOrder[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        for (int i = 1; i < levelOrder.length; i++) {
            TreeNode node = queue.poll();
            
            if (levelOrder[i] != null) {
                TreeNode leftChild = new TreeNode(levelOrder[i]);
                node.left = leftChild;
                queue.add(leftChild);
            }
            if (++i < levelOrder.length && levelOrder[i] != null) {
                TreeNode rightChild = new TreeNode(levelOrder[i]);
                node.right = rightChild;
                queue.add(rightChild);
            }
        }
        
        return root;
    }
}
