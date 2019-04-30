package P51TO100.P58;

public class P58_LengthofLastWord {
    public int lengthOfLastWord(String s) {
        int length = 0;
        String strim = s.trim();
        for(int i = 0;i < strim.length();i++){
            if(strim.charAt(i)==' '){
                length = 0;
            }else {
                length++;
            }
        }
        return length;
    }
}
