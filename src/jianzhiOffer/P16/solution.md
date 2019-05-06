# 题目
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
# 思路
1. (P16)
先将指数变成正的，再递归折半计算，算法复杂度O(logn)
# 吐槽
剑指OFFERP113页算法未考虑到指数小于0的情况
