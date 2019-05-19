package jianzhiOffer.P25;

import datastruct.ListNode;

public class P25 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        //
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        //比较大小，小的先进入
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            } else {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }
        }
        // 任一为空，直接连接另一条链表
        if (list1 == null) {
            cur.next = list2;
        } else {
            cur.next = list1;
        }
        return dummyHead.next;
    }
}
