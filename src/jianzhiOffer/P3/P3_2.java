package jianzhiOffer.P3;

//不占额外的空间
public class P3_2 {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        for ( int i= 0 ; i<length; i++) {
            int index = numbers[i];
            if (index >= length) {
                index -= length;
            }
            if (numbers[index] >= length) {
                duplication[0] = index;
                return true;
            }
            numbers[index] = numbers[index] + length;
        }
        duplication[0] = -1;
        return false;
    }
}
