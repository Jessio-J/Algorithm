package P51TO100.P71;
//以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
//
//        在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
//
//        请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。

import java.util.Stack;

public class P71_SimplifyPath {
    public String simplifyPath(String path) {
        if(path.equals("")){
            return "";
        }
        String[] parr = path.split("/");
        Stack<String> pst = new Stack<>();
        for(int i = 0;i<parr.length;i++){
            if(!parr[i].equals("")){
                if(parr[i].equals(".")){
                    continue;
                }else if(parr[i].equals("..")){
                    if(!pst.empty()){
                        pst.pop();
                    }
                }else {
                    pst.push(parr[i]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!pst.empty()){
            sb.insert(0,"/"+pst.pop());
        }
        if(sb.toString().equals("")){
            return "/";
        }
        return sb.toString();
    }
}
