package P101TO150.P143;

import datastruct.ListNode;

public class P143 {
    public void reorderList(ListNode head) {
        //快慢指针找到链表的中点
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head;
        ListNode low = head;
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        //得出的两个队列head和low
        ListNode p = head;
        ListNode q = reverseList(low);
        ListNode tmpp = null;
        ListNode tmpq = null;
        //将low插入head的间隙中
        while (q!=null&&q.next != null) {
            tmpp = p.next;
            p.next = q;
            tmpq = q.next;
            q.next = tmpp;
            p = tmpp;
            q = tmpq;
        }

    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode p = head.next;
        pre.next = null;
        ListNode af = null;
        while (p != null) {
            af = p.next;
            p.next = pre;
            pre = p;
            p = af;
        }
        return pre;
    }

}
