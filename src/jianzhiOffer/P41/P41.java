package jianzhiOffer.P41;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P41 {
    int count;
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, Comparator.reverseOrder());

    public void Insert(Integer num) {
        count++;
        if ((count & 1) == 0) { // 判断偶数的高效写法
            //偶数
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        } else {
            //奇数
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }

    public Double GetMedian() {
        if(count==0)
            throw new RuntimeException("no available number!");
        double result;
        //总数为奇数时，大顶堆堆顶就是中位数
        if((count&1)==1)
            result=maxHeap.peek();
        else
            result=(minHeap.peek()+maxHeap.peek())/2.0;
        return result;
    }
}
