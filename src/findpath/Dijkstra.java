package findpath;

public class Dijkstra {
    int[][] arcs;//邻接矩阵
    int[] minLenth = new int[6];//保存最短路径长度
    int[] visit = new int[6];//若final[i] = 1则说明 顶点vi已在集合S中
    int[] path = new int[6];
    int n = 6;//顶点个数
    int vstart = 0;//源点
    int v, w;

    void init() {
        //初始化顶点个数
        //初始化顶点
        //初始化邻接矩阵
        arcs = new int[][]{{0, 1, 12, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 0, 9, 3, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 5, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 4, 0, 13, 15},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 4},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,0}};

        //{...}
        //初始化原点到各点的距离
        for (v = 0; v < n; v++) {
            visit[v] = 0;
            minLenth[v] = arcs[vstart][v];
        }
    }

    void ShortestPath_DIJ() {
        visit[vstart] = 1; //初始化 v0顶点属于集合S
        //开始主循环 每次求得v0到某个顶点v的最短路径 并加v到集合S中
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            //选出到start点最短且没有被访问过的点
            for (w = 0; w < n; w++) {
                if (1 != visit[w]) {
                    if (minLenth[w] < min) {
                        v = w;
                        min = minLenth[w];
                    }
                }

            }
            //-----选点结束
            //选出该点后加入到合集S中
            visit[v] = 1;
            //更新当前最短路径和距离
            for (w = 0; w < n; w++) {
                if (1 != visit[w] &&arcs[v][w]<Integer.MAX_VALUE&& (min + arcs[v][w] < minLenth[w])) {
                    minLenth[w] = min + arcs[v][w];
                    path[w] = v;
                }
            }
        }
    }


    public int main() {
        init();
        ShortestPath_DIJ();
        for (int i = 0; i < n; i++) System.out.println("minLenth[%d] ="+minLenth[i]+"\n");
        for (int i = 0; i < n; i++) System.out.println("path[%d] ="+(path[i]+1)+"\n");
        return 0;
    }
}
