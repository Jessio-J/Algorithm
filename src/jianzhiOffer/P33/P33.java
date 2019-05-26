package jianzhiOffer.P33;

public class P33 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        return verify(sequence,0,sequence.length);
    }
    private boolean verify(int[] sequence,int start,int end){
        if(sequence==null||start-end==0){
            return false;
        }
        int root = sequence[end-1];
        int i = start;
        for(;i<end-1;i++){
            if(sequence[i]>root){
                break;
            }
        }
        int j = i;
        for(;j<end-1;j++){
            if(sequence[j]<root){
                return false;
            }
        }
        boolean left = true;
        if(i-start>0){
            left = verify(sequence,start,i);
        }
        boolean right = true;
        if(i<end-1){
            right = verify(sequence,start+i,end-1);
        }
        return left&&right;
    }
}
