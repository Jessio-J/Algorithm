package P101TO150.P102;

import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P102_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rList = new ArrayList<>();
        if (root == null) {
            return rList;
        }
        TreeLevel binaryNode;
        Queue<TreeLevel> queue = new LinkedList<>();
        //根节点入队
        queue.add(new TreeLevel(root,0));

        while (queue.size() != 0) {
            List<Integer> leveli ;
            //根节点出队
            binaryNode = queue.poll();
            //访问
            try{
                leveli = rList.get(binaryNode.level);
            }catch (IndexOutOfBoundsException e){
                leveli = new ArrayList<>();
                rList.add(leveli);
            }
            leveli.add(binaryNode.node.val);
            if (binaryNode.node.left != null) {
                //左子树入队
                queue.offer(new TreeLevel(binaryNode.node.left,binaryNode.level+1));
            }
            if (binaryNode.node.right != null) {
                //右子树入队
                queue.offer(new TreeLevel(binaryNode.node.right,binaryNode.level+1));
            }
        }
        return rList;
    }
    private class TreeLevel{
        public int level;
        public TreeNode node;
        public TreeLevel(TreeNode node,int level){
            this.level = level;
            this.node = node;
        }
        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public TreeNode getNode() {
            return node;
        }

        public void setNode(TreeNode node) {
            this.node = node;
        }
    }
}
