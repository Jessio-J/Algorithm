# 题目
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

>示例 1:
输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]

>示例 2:
输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]

# 算法
```java
public class P54_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> r = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return r;
        }
        //m行
        int m = matrix.length;
        //n列
        int n = matrix[0].length;
        if(n==1){
            for(int i = 0;i<m;i++){
                r.add(matrix[i][0]);
            }
            return r;
        }
        for (int i = 0; i < 1 + m / 2; i++) {
            //本层应该打印横边数字个数
            int j = n - 2 * i;
            //本层应该打印竖边数字个数
            int k = m - 2 * i - 2;
            //上边框
            for (int a = 0; a < j; a++) {
                r.add(matrix[i][i + a]);
            }
            //右边框
            if (j > 0)
                for (int a = 0; a < k; a++) {
                    r.add(matrix[i + 1 + a][n - i - 1]);
                }
            //下边框
            if (k >= 0)
                for (int a = 0; a < j; a++) {
                    r.add(matrix[m - i - 1][n - i - 1 - a]);
                }

            //左边框
            if (j > 1)
                for (int a = 0; a < k; a++) {
                    r.add(matrix[m - i - 2 - a][i]);
                }
            if (j <= 0 || k <= 0) {
                break;
            }
        }
        return r;
    }

}
```
思路：
该题为[leetcode习题集——48. 旋转图像](https://blog.csdn.net/qq_34064803/article/details/89389042)的变体，即使得`nxn`的矩阵变成了`nxm`矩阵，大致的思路还是一致的，都需要一层一层的去打印。
注意：
1. 上边框永远是首先需要打印的
2. 右边框需要本层横边数字个数大于0
3. 下边框需要竖边数字个数大于等于0
4. 左边框需要横边数字个数大于1