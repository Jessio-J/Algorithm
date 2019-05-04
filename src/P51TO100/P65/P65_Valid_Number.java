package P51TO100.P65;

//验证给定的字符串是否可以解释为十进制数字。
//
//        例如:
//
//        "0" => true
//        " 0.1 " => true
//        "abc" => false
//        "1 a" => false
//        "2e10" => true
//        " -90e3   " => true
//        " 1e" => false
//        "e3" => false
//        " 6e-1" => true
//        " 99e2.5 " => false
//        "53.5e93" => true
//        " --6 " => false
//        "-+3" => false
//        "95a54e53" => false
//
//        说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表：
//
//        数字 0-9
//        指数 - "e"
//        正/负号 - "+"/"-"
//        小数点 - "."
//        当然，在输入中，这些字符的上下文也很重要。
//
//        更新于 2015-02-10:
//        C++函数的形式已经更新了。如果你仍然看见你的函数接收 const char * 类型的参数，请点击重载按钮重置你的代码。

//状态机解决
public class P65_Valid_Number {
    public boolean isNumber(String s) {
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
                }else if(st.charAt(i)=='e'){
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
                }else if(st.charAt(i)=='e'){
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
