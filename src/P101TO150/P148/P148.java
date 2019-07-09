package P101TO150.P148;

import datastruct.ListNode;

public class P148 {
    public ListNode sortList(ListNode head) {
        if (head==null||head.next == null) {
            return head;
        } else {
            ListNode mid = head;
            ListNode p = head.next;
            //找出mid
            while(p!=null&&p.next!=null){
                mid = mid.next;
                p = p.next.next;
            }
            ListNode q = mid.next;
            mid.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(q);
            return merge(left,right);
        }
    }

    private ListNode merge(ListNode head1,ListNode head2) {

        ListNode p1 = null;
        ListNode q1 = null;
        ListNode head = null;
        if(head1.val>head2.val){
            head = head2;
            p1 = head1;
            q1 = head2.next;
        }else {
            head = head1;
            p1 = head1.next;
            q1 = head2;
        }
        ListNode w = head;
        while(p1!=null&&q1!=null){
            if(p1.val>q1.val){
                w.next = q1;
                w = q1;
                q1 =q1.next;
            }else {
                w.next = p1;
                w = p1;
                p1 = p1.next;
            }
        }
        if(p1!=null){
            w.next  = p1;
        }
        if(q1!=null){
            w.next = q1;
        }
        return head;
    }
}
