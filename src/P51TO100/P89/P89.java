package P51TO100.P89;

import java.util.ArrayList;
import java.util.List;

//格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
//
//        给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
//
//        示例 1:
//
//        输入: 2
//        输出: [0,1,3,2]
//        解释:
//        00 - 0
//        01 - 1
//        11 - 3
//        10 - 2
//
//        对于给定的 n，其格雷编码序列并不唯一。
//        例如，[0,2,3,1] 也是一个有效的格雷编码序列。
//
//        00 - 0
//        10 - 2
//        11 - 3
//        01 - 1
//        示例 2:
//
//        输入: 0
//        输出: [0]
//        解释: 我们定义格雷编码序列必须以 0 开头。
//        给定编码总位数为 n 的格雷编码序列，其长度为 2^n。当 n = 0 时，长度为 2^0 = 1。
//        因此，当 n = 0 时，其格雷编码序列为 [0]。
public class P89 {

    public List<Integer> grayCode(int n) {
        List<Integer> rList = new ArrayList<>();
        if(n<0){
            return rList;
        }else if(n==0){
            rList.add(0);
            return rList;
        }
        rList.add(0);
        rList.add(1);
        for(int i = 2;i<=n;i++){
            List<Integer> tmp = new ArrayList<>();
            int flag = 0;
            for(int num : rList){
                num = num<<1;
                tmp.add(num+flag);
                flag = 1 - flag;
                tmp.add(num+flag);
            }
            rList = new ArrayList<>();
            rList.addAll(tmp);
        }
        return rList;
    }

}
