package jianzhiOffer.P50;

public class P50 {
    public int FirstNotRepeatingChar(String str) {

        int[][] flag = new int[52][2];
        for(int i = 0;i<str.length();i++){

            int num = 0;
            if(str.charAt(i)-'a'>=0&&str.charAt(i)-'a'<=25){
                num = str.charAt(i)-'a';
            }else{
                num = str.charAt(i)-'A'+26;
            }
            flag[num][0]++;
            flag[num][1] = i;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<52;i++){
            if(flag[i][0]==1&&flag[i][1]<min){
                min = flag[i][1];
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}
