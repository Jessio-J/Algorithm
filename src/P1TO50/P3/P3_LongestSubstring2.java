package P1TO50.P3;

public class P3_LongestSubstring2 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            char cur = s.charAt(j);
            //找到当前字符出现的上一个位置
            i = Math.max(index[s.charAt(j)], i);

            //当前字符的当前位置和上次出现的位置差值，看是否比ans大，如果是则取更大值
            ans = Math.max(ans, j - i + 1);

            //index[]数组表示当前字符在String中出现的最大下标
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
    public static void main(String[] args){
        System.out.println(""+new P3_LongestSubstring2().lengthOfLongestSubstring("abcabcbb"));
    }
}
