package 分类.树;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=1448 lang=java
 *
 * [1448] 统计二叉树中好节点的数目
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
    int goodNum = 0;

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return goodNum;
        }
        dfs(root, root.val);
        return goodNum;
    }

    public void dfs(TreeNode node, int max) {
        if (node == null) {
            return;
        }
        if (node.val >= max) {
            goodNum++;
            max = node.val;
        }
        dfs(node.left, max);
        dfs(node.right, max);
    }

}

// @lc code=end
