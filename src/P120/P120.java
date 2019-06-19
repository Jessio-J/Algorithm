package P120;

import java.util.List;
//回溯思想超出时间限制
public class P120 {
    int minSum = Integer.MAX_VALUE;

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = 0;
        if((n=triangle.size())==0){
            return 0;
        }else if(n==1){
            return triangle.get(0).get(0);
        }
        solvePath(triangle,2,n,0,triangle.get(0).get(0));
        return minSum;
    }

    public void solvePath(List<List<Integer>> triangle, int level, int n, int lastIndex, int sum) {
        if (level <= n) {
            int index1 = triangle.get(level - 1).get(lastIndex);
            int index2 = triangle.get(level - 1).get(lastIndex + 1);
            int minIndex;
            int originalSum = sum;
            sum = originalSum + index2;
            minIndex = lastIndex + 1;

            if (level < n) {
                solvePath(triangle, level + 1, n, minIndex, sum);
            } else {
                if (minSum > sum) {
                    minSum = sum;
                }
            }
            sum = originalSum + index1;
            minIndex = lastIndex;
            if (level < n) {
                solvePath(triangle, level + 1, n, minIndex, sum);
            } else {
                if (minSum > sum) {
                    minSum = sum;
                }
            }

        }
    }
}
