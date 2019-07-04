package P101TO150.P109;

import datastruct.ListNode;
import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P109 {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> tmpList = new ArrayList<>();
        if(head==null){
            return null;
        }
        while(head!=null){
            tmpList.add(head.val);
            head = head.next;
        }
        Integer[] arr = tmpList.toArray(new Integer[tmpList.size()]);
        return  buildTree(arr,0,arr.length-1);

    }
//    public TreeNode sortedArrayToBST(int[] nums) {
//        return (nums==null||nums.length==0)?null:buildTree(nums,0,nums.length-1);
//    }
    private TreeNode buildTree(Integer[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int m = (l+r)>>1;
        TreeNode root = new TreeNode(nums[m]);
        root.left = buildTree(nums, l, m - 1);
        root.right = buildTree(nums, m + 1, r);
        return root;
    }
}
