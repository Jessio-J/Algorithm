package jianzhiOffer.P4;
//题目描述
//        在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
//回溯方法求解
public class P4 {
    boolean flag = false;
    public boolean Find(int target, int [][] array) {
        if(array.length==0||array[0].length==0){
            return false;
        }
        recursion(array,target,0,0);
        return flag;
    }
    private void recursion(int[][] array,int target,int i,int j){
        if(array[i][j]==target){
            flag = true;
        }else if(array[i][j]<target){
            if(flag==false&&j<array[0].length-1)
                recursion(array,target,i,j+1);
            if(flag==false&&i<array.length-1)
                recursion(array,target,i+1,j);
        }
    }
}
