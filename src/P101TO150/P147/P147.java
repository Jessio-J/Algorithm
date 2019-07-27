package P101TO150.P147;

import datastruct.ListNode;
//链表的插入排序
public class P147 {
    public ListNode insertionSortList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode sorted = head;

        ListNode unsorted = head.next;
        sorted.next = null;
        while(unsorted!=null){
            ListNode p = unsorted;
            unsorted = unsorted.next;
            ListNode q = sorted;
            if(p.val<sorted.val){
                p.next = sorted;
                sorted = p;
            }else {
                ListNode pre = q;
                q = q.next;
                while(q!=null&&p.val>q.val){
                    q = q.next;
                    pre = pre.next;
                }
                pre.next  = p;
                p.next = q;
            }
        }
        return sorted;
    }
}
