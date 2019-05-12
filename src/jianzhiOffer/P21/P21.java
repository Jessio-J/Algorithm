package jianzhiOffer.P21;

public class P21 {
    public void reOrderArray(int [] array) {
        int l = 0;
        int r = array.length-1;
        while(l<r){
            if((array[l]&1)==0){
                int temp = array[l];
                array[l] = array[r];
                array[r] = temp;
                r--;
            }else {
                l++;
            }
        }
        return;
    }
}
