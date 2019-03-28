package P30;

import java.util.ArrayList;
import java.util.List;
//给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
//
//        注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
public class P30_SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> rlist = new ArrayList<>();
        boolean indexFlag = false;
        int count = 0;
        if(s==null||s.equals("")){
            return rlist;
        }
        if(words==null||words.length==0){
            return rlist;
        }
        int wordsLen = words[0].length();
        int[] flag = new int[words.length];
        int i = 0;
        while(i+wordsLen<=s.length()){
            String si = s.substring(i,i+wordsLen);
            if(findWordInArray(si,words,flag)==1){
                indexFlag =true;
                count++;
                if(judgeFlag(flag)==1){
                    rlist.add(i-(words.length-1)*wordsLen);
                    flag = new int[words.length];
                    i = i - (words.length-1)*wordsLen+1;
                    count = 0;
                    continue;
                }
                i += wordsLen;
            }else {
                if(indexFlag){
                    i = i+1-wordsLen*count;
                    indexFlag =false;
                    count = 0;
                }else {
                    i += 1;
                }

                flag = new int[words.length];
            }
        }
        return rlist;
    }
    private int findWordInArray(String s,String[] words,int[] flag){
        for(int i = 0;i<words.length;i++){
            if(s.equals(words[i])&&flag[i]!=1){
                flag[i] = 1;
                return 1;
            }
        }
        return 0;
    }
    private int judgeFlag(int[] flag){
        for(int i = 0;i<flag.length;i++){
            if(flag[i]==0){
                return 0;
            }
        }
        return 1;
    }
}
