package arraysort;

import java.util.Arrays;

public class QuickSort{
    public int[] sort(int[] sarr){
        int[] arr = Arrays.copyOf(sarr,sarr.length);
        return quickSort(arr,0,arr.length-1);

    }
    private int[] quickSort(int[] arr,int l,int r){
        if(l < r){
            int index = partition(arr,l,r);
            quickSort(arr,l,index - 1);
            quickSort(arr,index+1,r);
        }
        return arr;
    }

    private int partition(int[] arr,int l,int r){
        //设定基准值p
        int p = l;//一般来说基准值可以任意取
        int index = p + 1;
        for(int i = index;i <= r;i++){
            if(arr[i] < arr[p]){
                SwapElement.swap(arr,i,index);
                index++;
            }
        }
        SwapElement.swap(arr,p,index-1);
        return index -1;
    }
}
