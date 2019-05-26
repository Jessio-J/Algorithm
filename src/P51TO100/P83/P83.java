package P51TO100.P83;

import datastruct.ListNode;

//同剑指offer第18题
public class P83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        int curVal = head.val;
        ListNode pre =head;
        ListNode p = head.next;
        ListNode q = head.next;
        while(p!=null){
            if(p.val>curVal){
                curVal = p.val;
                p = p.next;
                q = q.next;
                pre = pre.next;
            }else {
                while(q!=null&&q.val<=curVal){
                    q = q.next;
                }
                if(q!=null){
                    p.val = q.val;
                    curVal = q.val;
                    p = p.next;
                    pre = pre.next;
                }else {
                    pre.next = null;
                    break;
                }
            }
        }
        return head;
    }
}
