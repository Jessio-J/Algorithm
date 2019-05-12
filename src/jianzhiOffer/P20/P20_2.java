package jianzhiOffer.P20;

public class P20_2 {
    public boolean isNumeric(char[] str) {
        String s = new String(str);
        String st = s.trim();
        if(st.equals("")||st.equals(".")){
            return false;
        }
        boolean canFinish = false;
        boolean hasNum = false;
        int state = 0;
        for(int i = 0;i<st.length();i++){
            canFinish = false;
            //检测符号位
            if(state == 0){
                if(i==0&&(st.charAt(i)=='+'||st.charAt(i)=='-')){
                    state = 1;
                    continue;
                }else if(i==0&&st.charAt(i)>='0'&&st.charAt(i)<='9'){
                    hasNum = true;
                    canFinish = true;
                    state = 1;
                    continue;
                }else if(st.charAt(i)=='.'){
                    canFinish = true;
                    state = 2;
                    continue;
                }else {
                    return false;
                }
            }
            //监测整数位
            if(state == 1){
                if(st.charAt(i)>='0'&&st.charAt(i)<='9'){
                    hasNum = true;
                    canFinish = true;
                    continue;
                }else if(st.charAt(i)=='.'){
                    canFinish = true;
                    state = 2;
                    continue;
                }else if(st.charAt(i)=='e'||st.charAt(i)=='E'){
                    state = 3;
                    continue;
                }else {
                    return false;
                }
            }
            //监测小数位
            if(state == 2){
                if(st.charAt(i)>='0'&&st.charAt(i)<='9'){
                    hasNum = true;
                    canFinish = true;
                    continue;
                }else if(st.charAt(i)=='e'||st.charAt(i)=='E'){
                    state = 3;
                    continue;
                }else {
                    return false;
                }
            }
            //监测指数符号位
            if(state == 3){
                if((st.charAt(i)=='+'||st.charAt(i)=='-')){
                    state = 4;
                    continue;
                }else if(st.charAt(i)>='0'&&st.charAt(i)<='9'){
                    canFinish = true;
                    state = 4;
                    continue;
                }else {
                    return false;
                }
            }
            //监测指数位
            if(state == 4){
                if(st.charAt(i)>='0'&&st.charAt(i)<='9'){
                    canFinish = true;
                    continue;
                }else {
                    return false;
                }
            }
        }
        if(canFinish&&hasNum)
            return true;
        else
            return false;
    }
}
