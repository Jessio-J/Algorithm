package jianzhiOffer.P18;

import datastruct.ListNode;
//O(1)时间删除某个节点
public class P18 {
    public ListNode deleteNode(ListNode head,ListNode toBeDelete){
        if(head==null){
            return null;
        }
        //要删除的节点不是尾节点
        if(toBeDelete.next!=null){
            ListNode p = toBeDelete.next;
            toBeDelete.val = p.val;
            toBeDelete.next = p.next;
        }else if(head==toBeDelete){
            return null;
        }else {
            //删除尾节点
            ListNode p = head;
            while(p.next!=toBeDelete){
                p = p.next;
            }
            p.next = null;
        }
        return head;
    }

}
