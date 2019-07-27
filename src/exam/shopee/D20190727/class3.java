package exam.shopee.D20190727;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class class3 {
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListNode head = new ListNode(0);
        ListNode p = head;
        String line = scanner.nextLine();
        String[] arg = line.split(" ");

        for(String a:arg){
            ListNode q = new ListNode(Integer.parseInt(a));
            p.next = q;
            p = q;
        }
        ListNode dnode = delete(head.next);
        while (dnode!=null&&dnode.next!=null){
            System.out.print(dnode.val+" ");
            dnode = dnode.next;
        }
        if(dnode!=null)
        System.out.print(dnode.val+" ");

    }
    public static ListNode delete(ListNode head) {
        if(head == null||head.next==null){
            return head;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        ListNode p =new ListNode(-1);
        p.next = head;
        ListNode pre = p;
        ListNode cur= p.next;
        while((pre!=null||pre.next!=null)&&cur!=null){
            if(map.containsKey(cur.val)){
                pre.next = cur.next;
            }else {
                map.put(cur.val,1);
                pre = cur;
            }
            cur = cur.next;
        }
        return p.next;
    }
}
