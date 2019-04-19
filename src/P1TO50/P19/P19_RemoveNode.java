package P1TO50.P19;

import datastruct.ListNode;

//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
//        示例：
//
//        给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//        当删除了倒数第二个节点后，链表变为 1->2->3->5.
//        说明：
//
//        给定的 n 保证是有效的。
//
//        进阶：
//
//        你能尝试使用一趟扫描实现吗？
public class P19_RemoveNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null){
            return null;
        }
        int length = 1;
        ListNode p = head.next;
        while(p!=null){
            length++;
            p = p.next;
        }
        int index = length - n + 1;
        if(index == 1){
            return head.next;
        }
        ListNode blankHead = new ListNode(0);
        blankHead.next = head;
        p = head;
        int i = 1;
        while(i<index-1){
            i++;
            p = p.next;
        }
        p.next = p.next.next;
        return blankHead.next;
    }
}
