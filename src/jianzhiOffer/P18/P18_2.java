package jianzhiOffer.P18;

import datastruct.ListNode;

//在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
public class P18_2 {
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead==null){
            return null;
        }
        ListNode pre = null;
        ListNode p = pHead;
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
                    pHead = next;
                }else {
                    pre.next = next;
                }
                p = next;
            }
        }
        return pHead;
    }

}
