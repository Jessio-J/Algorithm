package P101TO150.P144;

import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P144_2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.empty())
        {
            while(root != null)
            {
                //先访问根
//                System.out.print(root.val + "->");
                rList.add(root.val);
                //根压栈
                stack.push(root);
                //再去左子树，直到左子树没有为止
                root = root.left;
            }
            if(!stack.empty())
            {
                //弹栈
                root = stack.pop();
                //去栈的右子树
                root = root.right;
            }
        }
        return rList;
    }
}
