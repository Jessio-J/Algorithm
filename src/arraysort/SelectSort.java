package arraysort;

import java.util.Arrays;

public class SelectSort {
    public int[] sort(int[] sarr){
        int[] arr = Arrays.copyOf(sarr,sarr.length);
        //N-1轮比较
        for(int i  =0;i<arr.length-1;i++){
            int min  =i;
            //每轮需要比较的次数为N-i
            for(int j = i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    //记录最小值元素下标
                    min = j;
                }
            }
            //将最小值min和i对应的数字进行交换
            if(i!=min){
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
        return arr;
    }
}
