package graph;
//并查集求；连通分量
public class ConnectedComponents {
    private int root(int[] roots, int i) {
        while (roots[i] != i) i = roots[roots[i]];
        return i;
    }
    public int countComponents(int n, int[][] edges) {
        int count = n;
        int[] roots = new int[n];
        for(int i=0; i<n; i++) roots[i] = i;
        for(int i=0; i<edges.length; i++) {
            int r1 = root(roots, edges[i][0]);
            int r2 = root(roots, edges[i][1]);
            if (r1 != r2) {
                roots[r2] = r1;
                count --;
            }
        }
        return count;
    }
}
