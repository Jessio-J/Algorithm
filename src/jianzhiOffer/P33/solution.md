# 题目
1. 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

# 思路
1. (P33)
二叉搜索树左子树小于根，右子树大于根，同时后序遍历根在最后面，按照这种思路递归区分左子树和右子树。