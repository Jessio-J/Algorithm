package P51TO100.P91;

public class P91 {
    public int numDecodings(String s) {
        if(s==null||s.length()==0||s.charAt(0)=='0'){
            return 0;
        }
        int[] count = new int[s.length()];
        count[0] = 1;
        for(int i = 1;i<s.length();i++){
            if(s.charAt(i)=='0'&&s.charAt(i-1)!='1'&&s.charAt(i-1)!='2'){
                return 0;
            }
            if(Integer.parseInt(s.substring(i-1,i+1))<=26&&s.charAt(i-1)!='0'){
                if(s.charAt(i)!='0'){
                    if(i==1){
                        count[i] = count[i-1]+1;
                    }else {
                        count[i] = count[i-1]+count[i-2];
                    }
                }else {

                    if(i==1){
                        count[i] = 1;
                    }else {
                        count[i] = count[i-2];
                    }
                }

            }else {
                count[i] = count[i-1];
            }
        }
        return count[s.length()-1];
    }
}
