package P51TO100.P62;
//递归，超时
public class P62_UniquePaths2 {
    int count = 0;
    public int uniquePaths(int m, int n) {
        getToEnd(m,n);
        return count;
    }
    private void getToEnd(int m,int n){
        if(m>1&&n>1){
            getToEnd(m-1,n);
            getToEnd(m,n-1);
        }else if(m==1||n==1) {
            count++;
            return;
        }
    }
}
