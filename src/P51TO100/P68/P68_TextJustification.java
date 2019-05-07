package P51TO100.P68;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P68_TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> r = new ArrayList<>();
        for(int i = 0;i<words.length;i++){
            int curWid = maxWidth-words[i].length();
            int count = 1;
            while(i+1<words.length&&curWid>0){
                curWid = curWid-words[++i].length()-1;
                count++;
            }
            if(curWid<0&&i<words.length){
                curWid = curWid + words[i].length()+1;
                i--;
                count--;
            }
            int a = count>1?curWid/(count-1):curWid;
            int b = count>1?curWid%(count-1):0;
            char[] str = new char[maxWidth];
            Arrays.fill(str,' ');
            int index = 0;
            for(int j = count-1;j>=0;j--){
                char[] temp = words[i-j].toCharArray();
                System.arraycopy(temp,0,str,index,temp.length);
                if(i==words.length-1){
                    index = index+temp.length+1;
                }else {
                    index = index+temp.length+(b-->0?1:0)+a+1;
                }
            }
            r.add(new String(str));
        }
        return r;
    }
}
