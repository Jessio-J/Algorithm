# 题目
1. 【约瑟夫环】每次从换种删除第m个，删除的顺序是什么样的
# 思路：
1. (P60)
- 动态规划求解
- 维护数组，n个骰子和为sum出现的次数等于 n-1个骰子 sum-1，sum-2，sum-3，sum-4，sum-5，sum-6 出现次数的总和