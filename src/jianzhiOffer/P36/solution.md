# 题目
1. 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
# 思路
1. (P36)
- 中序遍历该排序二叉树，可以知道中序遍历的结果是升序的
- 处理完某个节点之后，将该节点设置为lastNode，便于下一个节点的连接
