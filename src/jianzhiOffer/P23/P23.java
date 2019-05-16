package jianzhiOffer.P23;

import datastruct.ListNode;

public class P23 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode meet = meetingNode(pHead);
        if(meet==null){
            return null;
        }
        ListNode p = pHead;
        while(p!=meet){
            p=p.next;
            meet = meet.next;
        }
        return p;
    }
    ListNode meetingNode(ListNode head){
        if(head==null){
            return null;
        }
        ListNode pslow = head.next;
        if(pslow==null){
            return null;
        }
        ListNode pfast = pslow.next;
        while(pfast!=null&&pslow!=null){
            if(pfast==pslow){
                return pfast;
            }
            pslow = pslow.next;
            pfast = pfast.next;
            if(pfast!=null){
                pfast = pfast.next;
            }
        }
        return null;
    }
}
