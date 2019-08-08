package jianzhiOffer.P36;

import datastruct.TreeNode;

public class P36_2 {
//    链接：https://www.nowcoder.com/questionTerminal/947f6eb80d944a84850b0538bf0ec3a5?f=discussion
//    来源：牛客网

    public class Solution {
        TreeNode head = null;
        TreeNode realHead = null;
        public TreeNode Convert(TreeNode pRootOfTree) {
            ConvertSub(pRootOfTree);
            return realHead;
        }

        private void ConvertSub(TreeNode pRootOfTree) {
            if(pRootOfTree==null) return;
            ConvertSub(pRootOfTree.left);
            if (head == null) {
                head = pRootOfTree;
                realHead = pRootOfTree;
            } else {
                head.right = pRootOfTree;
                pRootOfTree.left = head;
                head = pRootOfTree;
            }
            ConvertSub(pRootOfTree.right);
        }
    }

}
