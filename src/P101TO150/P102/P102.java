package P101TO150.P102;

import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P102 {
    /**
     * 层序遍历
     * 递归
     */
    public List<List<Integer>> levelOrder(TreeNode Node) {
        List<List<Integer>> rList = new ArrayList<>();
        if (Node == null) {
            return rList;
        }
        //求树的深度
        int depth = depth(Node);
        //根据层次进行遍历
        for (int i = 1; i <= depth; i++) {
            List<Integer> leveli = new ArrayList<>();
            levelOrder(Node, i,leveli);
            rList.add(leveli);
        }
        return rList;
    }

    private void levelOrder(TreeNode Node, int level,List<Integer> leveli) {
        if (Node == null || level < 1) {
            return;
        }

        if (level == 1) {
            leveli.add(Node.val);
            return;
        }
        // 左子树
        levelOrder(Node.left, level - 1,leveli);
        // 右子树
        levelOrder(Node.right, level - 1,leveli);
    }
    /**
     * 求树高
     * 递归
     */
    public int depth(TreeNode Node) {
        if (Node == null) {
            return 0;
        }
        int l = depth(Node.left);
        int r = depth(Node.right);
        if (l > r) {
            return l + 1;
        } else {
            return r + 1;
        }
    }
}
