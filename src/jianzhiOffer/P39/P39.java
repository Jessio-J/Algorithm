package jianzhiOffer.P39;


public class P39 {
    public int MoreThanHalfNum_Solution(int [] array) {
        int middle = array.length>>1;
        int start = 0;
        int end = array.length-1;
        int index = partition(array,start,end);
        while(index!=middle){
            if(index>middle){
                end = index-1;
                index = partition(array,start,end);
            }
            else {
                start = index+1;
                index = partition(array,start,end);
            }
        }

        return check(array,index);
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
    private int check(int[] arr,int index){
        int count = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]==arr[index]){
                count++;
            }
        }
        return count>(arr.length>>1)?arr[index]:0;
    }
}
