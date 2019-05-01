package P51TO100.P61;

import datastruct.ListNode;

public class P61_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode p = head;
        ListNode q = head;
        ListNode r = null;
        int length = 0;
        if(head==null){
            return head;
        }
        //求链表长度
        while(p!=null){
            length++;
            p=p.next;
        }
        if(k%length==0){
            return head;
        }
        int index = length - k%length+1;
        for(int i = 0;i<index-2;i++){
            q = q.next;
        }
        r = q.next;
        q.next = null;
        ListNode rt = r;
        while(rt.next!=null){
            rt = rt.next;
        }
        rt.next = head;
        return r;
    }
}
