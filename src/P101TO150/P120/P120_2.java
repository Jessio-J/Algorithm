package P101TO150.P120;

import java.util.List;
//动态规划，从倒数第二层到顶层
public class P120_2 {
    int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--)
            for (int j = 0; j < triangle.get(i).size(); j++){
                int tmp = triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
                List<Integer> tmpList = triangle.get(i);
                tmpList.set(j,tmp);
            }
        return triangle.get(0).get(0);
    }
}
