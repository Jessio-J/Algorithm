package jianzhiOffer.P11;
//二分查找
public class P11 {
    public int minNumberInRotateArray(int[] array) {
        if(array==null||array.length==0){
            return 0;
        }
        return binSearch(array,0,array.length-1);
    }
    private int binSearch(int[] array,int l,int r){
        if(l==r){
            return array[l];
        }
        int mid = (l+r)>>1;
        if(array[l]>=array[r]){
            if(array[mid]>=array[l]){
                return binSearch(array,mid+1,r);
            }else {
                return binSearch(array, l, mid);
            }
        }else {
            return array[l];
        }
    }
}
