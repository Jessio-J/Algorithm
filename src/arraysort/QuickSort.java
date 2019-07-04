package arraysort;

import java.util.Arrays;

public class QuickSort{
    public int[] sort(int[] sarr){
        int[] arr = Arrays.copyOf(sarr,sarr.length);
        return quickSort(arr,0,arr.length-1);

    }
    private int[] quickSort(int[] arr,int l,int r){
        if(l < r){
            //找到当前数组的基准，左边比基准小，右边比基准大
            int index = partition(arr,l,r);
            //去左边找
            quickSort(arr,l,index - 1);
            //去右边找
            quickSort(arr,index+1,r);
        }
        return arr;
    }

    private int partition(int[] arr,int l,int r){
        //设定基准值p
        int p = l;//一般来说基准值可以任意取
        //定义基准线为p+1
        int index = p + 1;
        for(int i = index;i <= r;i++){
            //当前处理值小于基准值，交换当前值和基准线上的值，基准线++，基准线左侧的值都比基准线小
            if(arr[i] < arr[p]){
                SwapElement.swap(arr,i,index);
                index++;
            }
        }
        //最后交换基准线上之前最后的值与基准值
        SwapElement.swap(arr,p,index-1);
        return index -1;
    }
}
