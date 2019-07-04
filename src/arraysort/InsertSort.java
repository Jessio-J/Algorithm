package arraysort;

import java.util.Arrays;

public class InsertSort {
    public int[] sort(int[] sarr){
        int [] arr = Arrays.copyOf(sarr,sarr.length);
        for(int i = 0;i<arr.length;i++){
            int tmp = arr[i];
            int j =i;
            //比tmp大，则向后复制
            while (j>0&&tmp<arr[j-1]){
                arr[j] = arr[j-1];
                j--;
            }
            //存在更小的数，插入
            if(j!=i){
                arr[j] = tmp;
            }
        }
        return arr;
    }
}
