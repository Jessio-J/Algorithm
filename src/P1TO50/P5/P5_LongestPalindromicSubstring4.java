package P1TO50.P5;

/**
 * Manacher 算法找最长回文串（Manacher在1975年提出来的算法）
 * 同样也是中心点扩展算法，但是不是每碰到一个中心点就从1开始，
 *
 * 过程：id是已经找到的回文字符串的对称中心点，Right是右边界，left是左边界，在数组p[]中保存id的回文半径，
 * j是i关于id的对称点，若i<Right,则p[i]=Math.min(Right-i, p[j])，否则p[i]=1。对p[i]进行初始化以后，
 * 以i为中心，对i的回文半径p[i]进行更新。更新完毕后，如果i+p[i]>Right,则对Right和id进行更新。
 */
public class P5_LongestPalindromicSubstring4 {
    public String longestPalindrome(String s) {
        StringBuffer temp=new StringBuffer();
        temp.append("&");
        for(int i=0;i<s.length();i++) {
            temp.append("#");
            temp.append(s.charAt(i));
        }
        temp.append("#");

        int[] p=new int[temp.length()];
        int id=-1,right=-1;
        for(int i=1;i<temp.length();i++) {
            if(i<right) {
                p[i]=Math.min(right-i, p[2*id-i]);
            }
            else
                p[i]=1;

            while((i+p[i])<temp.length()&&(i-p[i])>=0&&temp.charAt(i+p[i])==temp.charAt(i-p[i])) {
                p[i]++;
            }

            if(i+p[i]>right) {
                right=i+p[i];
                id=i;
            }
        }

        int max=0,idx=0;
        for(int i=0;i<temp.length();i++) {
            if(p[i]>max) {
                max=p[i];
                idx=i;
            }
        }

        return s.substring((idx-max)/2, (idx+max)/2-1);

    }
}
