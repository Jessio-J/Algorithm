package jianzhiOffer.P20;

public class P20 {
    public boolean isNumeric(char[] str) {
        String s = new String(str);
        return s.matches("^\\s*[+-]?((\\d*\\.\\d+)|\\d+\\.?)([eE][+-]?\\d+)?\\s*$");
    }
}
