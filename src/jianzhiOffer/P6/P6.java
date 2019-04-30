package jianzhiOffer.P6;

import datastruct.ListNode;

import java.util.ArrayList;

public class P6 {
    ArrayList<Integer> r = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        printNode(listNode);
        return r;
    }
    private void printNode(ListNode l){
        if(l!=null&&l.next!=null){
            printNode(l.next);
        }
        if(l!=null){
            r.add(l.val);
        }
    }
}
