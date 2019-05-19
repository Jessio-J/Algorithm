package jianzhiOffer.P24;

import datastruct.ListNode;


public class P24 {
    //    输入一个链表，反转链表后，输出新链表的表头。
    public ListNode ReverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode rHead = null;
        head.next = null;
        while(cur!=null){
            ListNode next = cur.next;
            if(next==null){
                rHead = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return rHead;
    }
}
