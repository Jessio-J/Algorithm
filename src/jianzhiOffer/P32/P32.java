package jianzhiOffer.P32;

import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//层次遍历
public class P32 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> rlist = new ArrayList<>();
        if (root == null) {
            return rlist;
        }
        TreeNode binaryNode;
        Queue<TreeNode> queue = new LinkedList<>();
        //根节点入队
        queue.add(root);

        while (queue.size() != 0) {
            //根节点出队
            binaryNode = queue.poll();
            //访问
            rlist.add(binaryNode.val);
            if (binaryNode.left != null) {
                //左子树入队
                queue.offer(binaryNode.left);
            }
            if (binaryNode.right != null) {
                //右子树入队
                queue.offer(binaryNode.right);
            }
        }
        return rlist;
    }
}
