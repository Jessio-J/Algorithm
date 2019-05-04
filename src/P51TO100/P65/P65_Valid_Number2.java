package P51TO100.P65;
//正则表达式匹配
public class P65_Valid_Number2 {
    public boolean isNumber(String s) {
        return s.matches("^\\s*[+-]?((\\d*\\.\\d+)|\\d+\\.?)(e[+-]?\\d+)?\\s*$");
    }
}
