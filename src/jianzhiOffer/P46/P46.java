package jianzhiOffer.P46;

import java.util.ArrayList;
import java.util.List;

public class P46 {
    List<String> rList = new ArrayList<>();
    public List<String> translate(String raw) {
        if(raw.length()==0){
            return rList;
        }
        trans(raw,"",0);
        return rList;
    }

    private void trans(String raw, String trans, int index) {

        if (index < raw.length()) {
            if (raw.charAt(index) == '0') {
                String tmpString = trans + "a";
                trans(raw, tmpString, index + 1);
            } else {
                if (index != raw.length() - 1 && (raw.charAt(index) == '1' || raw.charAt(index) == '2' && raw.charAt(index + 1) - '0' < 6)) {
                    String tmpString = trans + (char) (Integer.parseInt(raw.substring(index, index + 2)) + 'a');
                    trans(raw, tmpString, index + 2);
                }
                String tmpString = trans + (char) (raw.charAt(index)-'0' + 'a');
                trans(raw, tmpString, index + 1);
            }
        }else {
            rList.add(trans);
        }
        return;
    }
}