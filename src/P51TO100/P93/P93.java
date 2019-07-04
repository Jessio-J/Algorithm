package P51TO100.P93;

import java.util.ArrayList;
import java.util.List;

public class P93 {
    List<String> rList = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if(s.length()<4){
            return rList;
        }
        split(s,0,1);
        return rList;
    }
    private void split(String s,int l,int seg){
        if(seg!=4){
            for(int i = 1;i<=3;i++){
                if(l+i<=s.length()){
                    int sub = Integer.parseInt(s.substring(l,l+i));
                    if(sub>=0&&sub<256){
                        StringBuilder sb = new StringBuilder(s);
                        sb.insert(l+i,'.');
                        split(sb.toString(),l+i+1,seg+1);
                    }
                    if(sub==0){
                        break;
                    }
                }else {
                    break;
                }
            }

        }else if(seg==4&&l<s.length()&&s.length()-l<=3){
            if(Integer.parseInt(s.substring(l,s.length()))<256&&!((s.length()-l)>1&&s.charAt(l)=='0'))
            rList.add(s);
        }

    }
}
