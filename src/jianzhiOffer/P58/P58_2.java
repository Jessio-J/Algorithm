package jianzhiOffer.P58;

public class P58_2 {
    public String LeftRotateString(String str,int n) {
        if(str.length()==0){
            return str;
        }
        int mod = n%str.length();
        return str.substring(mod,str.length())+str.substring(0,mod);
    }
}
