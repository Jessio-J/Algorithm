package P51TO100.P96;

import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P96 {
    public int numTrees(int n) {
        if(n<1){
            return 0;
        }
        int sum =0;
        int[] g = new int[n+1];
        g[0] = 1;
        g[1] = 1;
        for(int i = 2;i<=n;i++){
            int j = i-1;
            while(j>=0){
                g[i]+= g[j]*g[i-j-1];
                j--;
            }
        }
        return g[n];
    }

}
