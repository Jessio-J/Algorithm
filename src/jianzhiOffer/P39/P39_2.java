package jianzhiOffer.P39;

public class P39_2 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null){
            return 0;
        }
        int r = array[0];
        int times = 1;
        for(int i = 1;i<array.length;i++){
            if(times==0){
                r = array[i];
                times = 1;
            }else if (array[i]==r){
                times++;
            }else {
                times--;
            }
        }
        return  check(array,r);
    }
    private int check(int[] arr,int tar){
        int count = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]==tar){
                count++;
            }
        }
        return count>(arr.length>>1)?tar:0;
    }
}
