package ListNode;

import datastruct.ListNode;
//这里找到的mid是，两个中的第一个，三个中的第二个，四个中的第二个
public class findMid {
    public ListNode findMidNode(ListNode head){
        ListNode mid = head;
        ListNode p = head.next;
        //找出mid
        while(p!=null&&p.next!=null){
            mid = mid.next;
            p = p.next.next;
        }
        ListNode q = mid.next;
        //从mid断开
        mid.next = null;
        return mid;
    }
}
