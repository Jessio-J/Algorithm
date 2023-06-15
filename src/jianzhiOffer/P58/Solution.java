package jianzhiOffer.P58;

public class Solution {

    public String reverseLeftWords(String s, int n) {
        if(s == null){
            return s;
        }
        if(n >= s.length()){
            return s;
        }
        String left = s.substring(0, n);
        String right = s.substring(n);
        return right + left;
    }
    
}
