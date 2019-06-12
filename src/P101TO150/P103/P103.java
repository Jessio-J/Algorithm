package P101TO150.P103;

import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int length = 1;
        int cur = 0;
        while (!queue.isEmpty()) {
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                TreeNode t = queue.poll();
                if (t == null) {
                    continue;
                }
                if (cur == 0) {
                    subList.add(t.val);
                } else {
                    subList.add(0, t.val);
                }
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            list.add(subList);
            length = queue.size();
            cur = 1 - cur;
        }
        return list;
    }
}
