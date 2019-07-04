package arraysort;

import java.util.Arrays;

public class BubbleSort {
    public int[] sort(int[] sarr){
        int [] arr = Arrays.copyOf(sarr,sarr.length);
        int max = arr.length-1;
        //一共i轮
        for(int i = 0;i<max;i++){
            for(int j = 0;j<max-i;j++){
                //大数上浮
                if(arr[j+1]<arr[j]){
                    swap(arr,j,j+1);
                }
            }
        }
        return arr;
    }
    private void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }
}
