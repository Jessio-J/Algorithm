package jianzhiOffer.P59;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class P59 {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        //数组双端队列
        ArrayDeque<Integer> s = new ArrayDeque<>();
        for(int i=0;i<num.length;++i){
            //将队尾所有比当前num[i]值小的清出去，队首一直是最大的
            while(s.size()>0 && num[s.peekLast()]<=num[i])
                s.pollLast();
            //队首下标和当前下标值查超过滑动窗口大小，队首出队
            while(s.size()>0 && i-s.peekFirst()+1>size)
                s.pollFirst();
            //当前值入队
            s.offerLast(i);
            //当滑动窗口首地址i大于等于size时才开始写入窗口最大值
            if(size>0&&i+1>=size)
                //写的最大值就是双端队列的首部
                res.add(num[s.peekFirst()]);
        }
        return res;
    }
}
