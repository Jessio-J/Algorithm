package arraysort;

import java.util.Arrays;

public class MergeSort {
    public int[] sort(int[] sarr) {
        int[] arr = Arrays.copyOf(sarr, sarr.length);
        if (arr.length < 2) {
            return arr;
        }
        mergeSort(arr,0,arr.length-1);
        return arr;
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        } else {
            int mid = (left + right) >> 1;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr,left,mid,right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1,k=0;
        while(i<=mid&&j<=right){
            if(arr[i]<arr[j]){
                tmp[k++] = arr[i++];
            }else {
                tmp[k++] = arr[j++];
            }
        }
        while(i<=mid)
            tmp[k++] = arr[i++];
        while (j<=right)
            tmp[k++] = arr[j++];
        for(k = 0;k<tmp.length;k++){
            arr[left+k] = tmp[k];
        }
    }
}
