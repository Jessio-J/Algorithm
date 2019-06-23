package P101TO150.P125;

public class P125 {
    public boolean isPalindrome(String s) {
        if(s.length()==0||s.length()==1){
            return true;
        }
        s = s.toLowerCase();
        int i = 0,j = s.length()-1;
        while(i<j){
            while(i<=j&&!(s.charAt(i)>='a'&&s.charAt(i)<='z'||s.charAt(i)>='A'&&s.charAt(i)<='Z'||s.charAt(i)>='0'&&s.charAt(i)<='9')){
                i++;
            }
            while(i<=j&&!(s.charAt(j)>='a'&&s.charAt(j)<='z'||s.charAt(j)>='A'&&s.charAt(j)<='Z'||s.charAt(i)>='0'&&s.charAt(i)<='9')) {
                j--;
            }
            if(i<=j&&s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
