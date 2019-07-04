package P51TO100.P82;

import datastruct.ListNode;
//同剑指Offer第18题
public class P82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode pre = null;
        ListNode p = head;
        while(p !=null){
            ListNode next = p.next;
            boolean del = false;
            if(next!=null&&next.val==p.val){
                del = true;
            }
            if(!del){
                pre = p;
                p = p.next;
            }else {
                int val = p.val;
                ListNode pDel = p;
                while(pDel!=null&&pDel.val==val){
                    next = pDel.next;
                    pDel = next;
                }
                if(pre==null){
                    head = next;
                }else {
                    pre.next = next;
                }
                p = next;
            }
        }
        return head;
    }
}
