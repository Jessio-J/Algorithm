package jianzhiOffer.P4;

public class P4_2 {
//    链接：https://www.nowcoder.com/questionTerminal/abc3fe2ce8e146608e868a70efebf62e
//    来源：牛客网
//    作者：楚云天

    public boolean Find(int [][] array,int target) {
        int row=0;
        int col=array[0].length-1;
        while(row<=array.length-1&&col>=0){
            if(target==array[row][col])
                return true;
            else if(target>array[row][col])
                row++;
            else
                col--;
        }
        return false;

    }
}
