# 题目
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
# 思路：
1. (P51)
采用归并排序
- 从上向下左右裂开，知道不能裂为止
- 对裂开的左右两端进行合并（在进行本轮合并时，上轮的合并已经使得左右两端分别有序了）
- 合并时，如果出现左端某数小于右端，直接加入辅助数组，如果出现左端某数大于右端，则将右端数加入数组，同时计左端a[i]后面的都算是对a[j]的逆序对
- 将合并后的辅助数组赋值给原数组，合并完成