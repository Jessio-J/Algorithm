package jianzhiOffer.P18;

import datastruct.ListNode;

//在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
public class P18_3 {
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead==null){
            return null;
        }
        int curVal = pHead.val;
        ListNode pre =pHead;
        ListNode p = pHead.next;
        ListNode q = pHead.next;
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
        return pHead;
    }

}
