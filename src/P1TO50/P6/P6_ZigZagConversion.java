package P1TO50.P6;

public class P6_ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows >= s.length()||numRows == 1){
            return s;
        }
        int length = s.length();
        int index = (length - 1)/(numRows -1);
        int v = (index)/2+1;
        char[] array = s.toCharArray();
        String result = "";
        for(int i = 0;i<numRows;i++){
            for(int j = 1;j <= v;j++){
                int a = (2*j-1)*(numRows-1)-(numRows-1-i);
                if(a<length&&i<numRows-1){
                    result += array[(2*j-1)*(numRows-1)-(numRows-1-i)];
                }
                int b = (2*j-1)*(numRows-1)+(numRows-1-i);
                if(b<length&&i>0){
                    result += array[(2*j-1)*(numRows-1)+(numRows-1-i)];
                }
            }
        }
        return result;
    }
}
