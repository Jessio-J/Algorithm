# 题目
1. 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
# 思路
1. (P30)
采用辅助栈，每次压入一个元素到栈中，都压入一个最小值到辅助栈中，例如：
<br>
数据栈&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;辅助栈&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;最小值
<br>
3&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3
<br>
3,4&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3,3&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3
<br>
3,4,2&nbsp;&nbsp;&nbsp;3,3,2&nbsp;&nbsp;&nbsp;&nbsp;2

