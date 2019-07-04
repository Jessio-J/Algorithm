package P101TO150.P142;

import datastruct.ListNode;

public class P142 {
    public ListNode detectCycle(ListNode head) {
        int count = countCycle(head);
        if(count>0){
            ListNode p = head;
            while (count>0){
                count--;
                p = p.next;
            }
            ListNode q = head;
            while(p!=q){
                p = p.next;
                q = q.next;
            }
            return p;
        }else {
            return null;
        }
    }
    private int countCycle(ListNode head) {
        if(head==null){
            return 0;
        }
        int count =0;
        ListNode low = head;
        ListNode fast = head;
        while(low!=null&&fast!=null){
            low = low.next;
            fast = fast.next;
            if(fast!=null){
                fast = fast.next;
                count++;
            }
            if(low==fast&&low!=null){
                return count;
            }
        }
        return 0;
    }
}
