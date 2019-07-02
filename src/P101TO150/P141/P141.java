package P101TO150.P141;

import datastruct.ListNode;

public class P141 {
    //判断是否有环
    //采用快慢指针做
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode low = head;
        ListNode fast = head;
        while(low!=null&&fast!=null){
            low = low.next;
            fast = fast.next;
            if(fast!=null){
                fast = fast.next;
            }
            if(low==fast&&low!=null){
                return true;
            }
        }
        return false;

    }
}
