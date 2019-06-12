package jianzhiOffer.P40;

import java.util.ArrayList;

public class P40 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> rList = new ArrayList<>();
        if(input.length==0||k<=0||k>input.length){
            return rList;
        }
        int start = 0;
        int end = input.length-1;
        int index = partition(input,start,end);
        while(index!=k-1){
            if(index>k-1){
                end = index - 1;
                index = partition(input,start,end);
            }else {
                start = index+1;
                index = partition(input,start,end);
            }
        }
        for(int i = 0;i<k;i++){
            rList.add(input[i]);
        }
        return rList;
    }
    private int partition(int[] arr,int l,int r){
        //设定基准值p
        int p = l;//一般来说基准值可以任意取
        int index = p + 1;
        for(int i = index;i <= r;i++){
            if(arr[i] < arr[p]){
                swap(arr,i,index);
                index++;
            }
        }
        swap(arr,p,index-1);
        return index -1;
    }
    private  void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
