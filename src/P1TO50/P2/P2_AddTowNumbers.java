package P1TO50.P2;//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
//        如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
//        您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//        示例：
//
//        输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//        输出：7 -> 0 -> 8
//        原因：342 + 465 = 807

/**
 * Definition for singly-linked list.
 * public class P1TO50.P2.ListNode {
 *     int val;
 *     P1TO50.P2.ListNode next;
 *     P1TO50.P2.ListNode(int x) { val = x; }
 * }
 */
public class P2_AddTowNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long sum1=0,sum2=0,sum=0;
        int index1 = 0,index2 = 0;
        while (l1 != null){
            sum1 += l1.val* Math.pow(10,index1);
            index1++;
            l1 = l1.next;
        }
        while (l2 != null){
            sum2 += l2.val* Math.pow(10,index2);
            index2++;
            l2 = l2.next;
        }
        sum = sum1 + sum2;
        ListNode head = new ListNode((int)(sum%10));
//        sum = sum / 10;
        ListNode l = head;
        while (sum/10 != 0){
            sum = sum / 10;
            ListNode li = new ListNode((int)(sum%10));
            l.next = li;
            l = li;
        }
//        l.next = new P1TO50.P2.ListNode(sum);
        return head;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(9);
//        l1.next = new P1TO50.P2.ListNode(8);
        ListNode l2 = new ListNode(1);
        ListNode p2 = l2;
        for(int i = 0;i<9;i++){
            p2.next = new ListNode(9);
            p2 = p2.next;
        }
//        l2.next = new P1TO50.P2.ListNode(8);
        P2_AddTowNumbers calc = new P2_AddTowNumbers();
        ListNode l3 = calc.addTwoNumbers(l1,l2);
        while (l3!= null){
            System.out.print(""+l3.val+"->");
            l3 = l3.next;
        }
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
