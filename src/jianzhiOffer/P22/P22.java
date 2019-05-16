package jianzhiOffer.P22;

import datastruct.ListNode;

public class P22 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null){
            return null;
        }
        if(k==0){
            return null;
        }
        ListNode p = head;
        for(int i= k-1;i>0;i--){
            p = p.next;
            if(p==null){
                return null;
            }
        }
        ListNode q= head;
        while(p.next!=null){
            p = p.next;
            q = q.next;
        }
        return q;
    }
}
