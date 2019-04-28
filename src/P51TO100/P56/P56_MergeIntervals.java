package P51TO100.P56;

import java.util.Arrays;
import java.util.Vector;

public class P56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals==null||intervals.length==0){
            return new int[][]{};
        }
        //用向量暂存变长的数组
        Vector vector = new Vector();
        //对区间按左边界从低到高排序
        sort(intervals);
        int left = intervals[0][0];
        int right = intervals[0][1];
        //遍历合并区间
        for(int i = 1;i<intervals.length;i++){
            if(intervals[i][0]>=left&&intervals[i][0]<=right){
                right = right>intervals[i][1]?right:intervals[i][1];
            }else {
                vector.addElement(new int[]{left,right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        vector.addElement(new int[]{left,right});
        int[][] r = new int[vector.size()][2];
        //向量转化成数组
        vector.copyInto(r);
        return r;
    }
    //快速排序（按照区间左值排序）
    private void sort(int[][] arr){
        quickSort(arr,0,arr.length-1);
    }
    private void quickSort(int[][] arr,int l,int r){
        if(l < r){
            int index = partition(arr,l,r);
            quickSort(arr,l,index - 1);
            quickSort(arr,index+1,r);
        }
    }

    private int partition(int[][] arr,int l,int r){
        //设定基准值p
        int p = l;//一般来说基准值可以任意取
        int index = p + 1;
        for(int i = index;i <= r;i++){
            if(arr[i][0] < arr[p][0]){
                swap(arr,i,index);
                index++;
            }
        }
        swap(arr,p,index-1);
        return index -1;
    }
    private void swap(int[][] arr,int i,int j){
        int tmp1 = arr[i][0];
        int tmp2 = arr[i][1];
        arr[i][0] = arr[j][0];
        arr[i][1] = arr[j][1];
        arr[j][0] = tmp1;
        arr[j][1] = tmp2;
    }
}
