package P101TO150.P109;

import datastruct.ListNode;
import datastruct.TreeNode;

public class P109_2 {
    public TreeNode buildTreeNode(ListNode head, ListNode tail) {
        if(head==tail){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        //找到mid=slow
        while(fast!=tail&&fast.next!=tail){
            fast=fast.next.next;
            slow=slow.next;
        }
        TreeNode root=new TreeNode(slow.val);
        root.left=buildTreeNode(head,slow);
        root.right=buildTreeNode(slow.next,fast);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        return buildTreeNode(head,null);
    }
}
