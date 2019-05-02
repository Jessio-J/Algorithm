package jianzhiOffer.P8;

import datastruct.TreeLinkNode;
import datastruct.TreeNode;

public class P8 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode.right!=null) {
            //下一个节点在右子树中
            TreeLinkNode q = pNode.right;
            while(q.left!=null){
                q = q.left;
            }
            return q;
        }else if(pNode.next!=null){
            if(pNode == pNode.next.left){
                return pNode.next;
            }else if(pNode == pNode.next.right){
                TreeLinkNode q = pNode.next;
                while (q.next!=null){
                    if(q == q.next.left){
                        return q.next;
                    }
                    q = q.next;
                }
            }
        }
        return null;
    }

}
