package P51TO100.P92;

import datastruct.ListNode;

public class P92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||head.next==null||m==n){
            return head;
        }
        int index = 1;
        ListNode p =  head;
        if(m==1){
            ListNode last = p;
            ListNode first = null;
            ListNode rpre = null;
            while (p!=null&&index-1!=n){
                ListNode q = p.next;
                p.next = rpre;
                rpre = p;
                first = p;
                p = q;
                index++;
            }
            last.next = p;
            return first;
        }else {
            //找到m前的一个数字
            while(p!=null&&index+1!=m){
                index++;
                p = p.next;
            }
            ListNode s1 = p;
            p = p.next;
            index++;
            ListNode last = p;
            ListNode first = null;
            ListNode rpre = null;
            while (p!=null&&index-1!=n){
                ListNode q = p.next;
                p.next = rpre;
                rpre = p;
                first = p;
                p = q;
                index++;
            }
            s1.next = first;
            last.next = p;
            return head;
        }



    }
}
