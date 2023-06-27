package 分类.树;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=872 lang=java
 *
 * [872] 叶子相似的树
 */
import datastruct.TreeNode;

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<Integer>();
        preOrder(root1, list1);

        List<Integer> list2 = new ArrayList<Integer>();
        preOrder(root2, list2);
        if (list1.size() == list2.size()) {
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i) != list2.get(i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void preOrder(TreeNode Node, List<Integer> list) {
        if (Node != null) {
            if (Node.left == null && Node.right == null) {
                list.add(Node.val);
            } else {
                preOrder(Node.left, list);
                preOrder(Node.right, list);
            }
        }
    }
    
}
// @lc code=end
