package P51TO100.P62;
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//
//        机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//
//        问总共有多少条不同的路径？
//
//
//
//        例如，上图是一个7 x 3 的网格。有多少可能的路径？
//
//        说明：m 和 n 的值均不超过 100。
//直接用排列组合去做，会产生溢出
public class P62_UniquePaths {
    public int uniquePaths(int m, int n) {
        if(m<1||n<1){
            return 0;
        }
        if(m<2||n<2){
            return 1;
        }
        int min = Math.min(m-1,n-1);
        return arrange(m+n-2,min)/ arrange(min,min);
    }
    private int arrange(int a, int b){
        if(b==1){
            return a;
        }
        return a* arrange(a-1,b-1);
    }
}
