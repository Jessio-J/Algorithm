package jianzhiOffer.P36;

import datastruct.TreeNode;
//将排序二叉树转换成双向链表
public class P36 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode lastNode = null;
        convertNode(pRootOfTree,lastNode);
        while(pRootOfTree!=null&&pRootOfTree.left!=null){
            pRootOfTree = pRootOfTree.left;
        }
        return  pRootOfTree;
    }
    private TreeNode convertNode(TreeNode node,TreeNode lastNode){
        if(node==null){
            return null;
        }
        TreeNode cur = node;
        if(cur.left!=null){
            lastNode = convertNode(cur.left,lastNode);
        }
        cur.left = lastNode;
        if(lastNode!=null){
            lastNode.right=cur;
        }
        lastNode = cur;
        if(cur.right!=null){
            lastNode = convertNode(cur.right,lastNode);
        }
        return lastNode;
    }
}
