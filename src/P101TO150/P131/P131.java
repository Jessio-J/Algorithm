package P101TO150.P131;

import java.util.ArrayList;
import java.util.List;

public class P131 {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s.length()==0){
            return result;
        }
        splitString(s,0,new ArrayList<>());
        return result;
    }
    private void splitString(String s,int index,List<String> rList){
        if(index==s.length()){
            List<String> tmp = new ArrayList<>();
            tmp.addAll(rList);
            result.add(tmp);
        }else {
            for(int i = index;i<s.length();i++){
                if(judge(s,index,i)){
                    rList.add(s.substring(index,i+1));
                    splitString(s,i+1,rList);
                    rList.remove(rList.size()-1);
                }
            }
        }
    }
    private boolean judge(String s,int i,int j){
        if(i==j){
            return true;
        }
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
