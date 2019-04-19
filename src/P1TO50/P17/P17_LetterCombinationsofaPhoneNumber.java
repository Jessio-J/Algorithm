package P1TO50.P17;

import java.util.ArrayList;
import java.util.List;
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
//        给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//        示例:
//
//        输入："23"
//        输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
public class P17_LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<String>();
        return partCombinations(digits, 0 , digits.length() - 1);
    }

    private List<String> partCombinations(String str, int l, int r) {
        if (l == r) {
            String characters = getNumberMap(String.valueOf(str.charAt(l)));
            List<String> strs = new ArrayList<>();
            for(int i=0;i<characters.length();i++){
                strs.add(String.valueOf(characters.charAt(i)));
            }
            return strs;
        }
        else {
            int mid = (l + r)/2;
            List<String> lcpLeft =   partCombinations(str, l , mid);
            List<String> lcpRight =  partCombinations(str, mid + 1,r);
            return combine(lcpLeft, lcpRight);
        }
    }
    private String getNumberMap(String num){
        switch (num){
            case "2":return "abc";
            case "3":return "def";
            case "4":return "ghi";
            case "5":return "jkl";
            case "6":return "mno";
            case "7":return "pqrs";
            case "8":return "tuv";
            case "9":return "wxyz";
            default:return "";
        }
    }
    private List<String> combine(List<String> left,List<String> right) {
        List<String> strCombine = new ArrayList<>();
        for(String leftString :left){
            for(String rightString :right){
                strCombine.add(leftString+rightString);
            }
        }
        return strCombine;
    }
}
