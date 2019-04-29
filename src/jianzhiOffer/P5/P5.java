package jianzhiOffer.P5;
//题目描述
//        请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
public class P5 {
//    链接：https://www.nowcoder.com/questionTerminal/4060ac7e3e404ad1a894ef3e17650423
//    来源：牛客网
//另外开辟空间来做
    public class Solution {
        public String replaceSpace(StringBuffer str) {
            String sti = str.toString();
            char[] strChar = sti.toCharArray();
            StringBuffer stb = new StringBuffer();
            for(int i=0;i<strChar.length;i++){
                if(strChar[i]==' '){
                    stb.append("%20");
                }else{
                    stb.append(strChar[i]);
                }
            }
            return stb.toString();
        }
    }
}
