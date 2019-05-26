package jianzhiOffer.P32;

import datastruct.TreeNode;

import java.util.Stack;

public class P32_2 {
    public void print(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode>[] levels = new Stack[2];
        int cur = 0;
        int next = 1;
        levels[cur].push(root);
        while(!levels[0].empty()||!levels[1].empty()){
            TreeNode p = levels[cur].pop();

            System.out.println(p.val);
            if(cur==0){
                if(p.left!=null){
                    levels[next].push(p.left);
                }
                if(p.right!=null) {
                    levels[next].push(p.right);
                }
            }else {
                if(p.right!=null){
                    levels[next].push(p.right);
                }
                if(p.left!=null) {
                    levels[next].push(p.left);
                }
            }
            if(levels[cur].empty()){
                cur = 1-cur;
                next = 1 - next;
            }
        }
    }
}
