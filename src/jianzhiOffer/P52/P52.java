package jianzhiOffer.P52;

import datastruct.ListNode;

public class P52 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = getLength(pHead1);
        int len2 = getLength(pHead2);
        if(len1>len2){
            int dif = len1 - len2;
            while (dif>0){
                pHead1 = pHead1.next;
                dif--;
            }
        }else {
            int dif = len2 - len1;
            while (dif>0){
                pHead2 = pHead2.next;
                dif--;
            }
        }
        while(pHead1!=null){
            if(pHead1==pHead2){
                return pHead1;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }
    private int getLength(ListNode head){
        if(head==null){
            return 0;
        }
        int count = 0;
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
    }
}
