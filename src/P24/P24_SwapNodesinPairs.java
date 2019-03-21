package P24;

import datastruct.ListNode;

//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
//        你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
//        示例:
//
//        给定 1->2->3->4, 你应该返回 2->1->4->3.
public class P24_SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = head;
        ListNode v = null;
        while(p.next != null && p.next.next != null){
            p.next = q.next;
            v = p.next.next;
            p.next.next = q;
            q.next = v;
            p = q;
            q = v;
        }
        return dummy.next;
    }
}
