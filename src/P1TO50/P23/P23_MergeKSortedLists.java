package P1TO50.P23;

import datastruct.ListNode;
//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
//
//        示例:
//
//        输入:
//        [
//        1->4->5,
//        1->3->4,
//        2->6
//        ]
//        输出: 1->1->2->3->4->4->5->6
//分治思想求解
public class P23_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0){
            return null;
        }
        return partMerge(lists,0,lists.length-1);
    }
    private ListNode partMerge(ListNode[] lists,int l,int r){
        if(l==r){
            return lists[l];
        }else {
            int mid = (l + r)/2;
            ListNode l1 = partMerge(lists,l,mid);
            ListNode l2 = partMerge(lists,mid+1,r);
            return mergeTwoLists(l1,l2);
        }
    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 类似归并排序中的合并过程
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummyHead.next;
    }
}
