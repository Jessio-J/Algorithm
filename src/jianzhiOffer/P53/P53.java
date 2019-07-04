package jianzhiOffer.P53;

public class P53 {
    public int GetNumberOfK(int[] array, int k) {
        if(array.length==0){
            return 0;
        }
        int index = getNumFromPartArray(array,0,array.length-1,k);
        if(index>=0){
            return getCount(array,index,k);
        }else {
            return 0;
        }
    }

    private int getNumFromPartArray(int[] array, int l, int r,int target) {
        if(l == r){
            if(array[l]==target){
                return l;
            }
        }else {
            int mid = (l+r)>>1;
            if(array[mid]==target){
                return mid;
            }else if(array[mid]>target){
                return getNumFromPartArray(array,l,mid,target);
            }else{
                return getNumFromPartArray(array,mid+1,r,target);
            }
        }
        return -1;
    }
    private int getCount(int[] array,int index,int target){
        int count = 0;
        int i = index;
        int j = index+1;
        while(i>=0){
            if(array[i--]==target){
                count++;
            }else {
                break;
            }
        }
        while(j<array.length){
            if(array[j++]==target){
                count++;
            }else {
                break;
            }
        }
        return count;
    }
}
