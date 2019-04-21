package P51TO100.P51;

import java.util.ArrayList;
import java.util.List;

public class P51_NQueens {
    List<List<String>> rlist =  new ArrayList<>();
    String cur0 = "";
    public List<List<String>> solveNQueens(int n) {
        int[] rows = new int[n];
        int[] column = new int[n];
        int[] left = new int[n*2-1];
        int[] right = new int[n*2-1];
        for(int k = 0;k<n-1;k++){
            cur0 += ".";
        }
        recursion(n,rows,column,left,right,new ArrayList<>(),0,0);
        return rlist;
    }
    private void recursion(int n,int[] rows,int[] column,int[] left,int[] right,List<String> cur,int i,int j){
        if(rows[i]==0&&column[j]==0&&left[i-j+n-1]==0&&right[i+j]==0){
            rows[i]=1;
            column[j]=1;
            left[i-j+n-1]=1;
            right[i+j]=1;
            String curi = cur0.substring(0,j)+"Q"+cur0.substring(j,n-1);
            cur.add(curi);
            if(i==n-1){
                List<String> listi = new ArrayList<>();
                listi.addAll(cur);
                rlist.add(listi);
            }else {
                recursion(n,rows,column,left,right,cur,i+1,0);
            }
            //还原
            rows[i]=0;
            column[j]=0;
            left[i-j+n-1]=0;
            right[i+j]=0;
            cur.remove(i);
            if(j<n-1){
                recursion(n,rows,column,left,right,cur,i,j+1);
            }
        }else {
            if(j<n-1){
                recursion(n,rows,column,left,right,cur,i,j+1);
            }
        }
    }
}
