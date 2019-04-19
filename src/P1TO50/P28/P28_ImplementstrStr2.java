package P1TO50.P28;
//思路：利用字符串的特性解题
public class P28_ImplementstrStr2 {
    public int strStr(String haystack, String needle) {
        if ((haystack == null) || (needle == null)) {
            return -1;
        } else {
            int lengthH = haystack.length();
            int lengthN = needle.length();
            if (lengthN == 0) {
                return 0;
            } else if (lengthH >= lengthN) {
                for (int i = 0; i <= (lengthH - lengthN); i++) {
                    if (haystack.charAt(i) == needle.charAt(0)) {
                        String temp = haystack.substring(i, i + lengthN);
                        if (needle.equals(temp)) {
                            return i;
                        }
                    }
                }
            }

            return -1;
        }
    }
}
