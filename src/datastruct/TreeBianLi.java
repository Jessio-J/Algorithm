package datastruct;

import datastruct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeBianLi {
    /**
     * 前序遍历
     * 递归
     */
    public void preOrder(TreeNode Node)
    {
        if (Node != null)
        {
            System.out.print(Node.val + "->");
            preOrder(Node.left);
            preOrder(Node.right);
        }
    }

    /**
     * 中序遍历
     * 递归
     */
    public void midOrder(TreeNode Node)
    {
        if (Node != null)
        {
            midOrder(Node.left);
            System.out.print(Node.val + "->");
            midOrder(Node.right);
        }
    }

    /**
     * 后序遍历
     * 递归
     */
    public void posOrder(TreeNode Node)
    {
        if (Node != null)
        {
            posOrder(Node.left);
            posOrder(Node.right);
            System.out.print(Node.val + "->");
        }
    }
    /**
     * 层序遍历
     * 递归
     */
    public void levelOrder(TreeNode Node) {
        if (Node == null) {
            return;
        }
        //求树的深度
        int depth = depth(Node);
        //根据层次进行遍历
        for (int i = 1; i <= depth; i++) {
            levelOrder(Node, i);
        }
    }

    private void levelOrder(TreeNode Node, int level) {
        if (Node == null || level < 1) {
            return;
        }

        if (level == 1) {
            System.out.print(Node.val + "->");
            return;
        }

        // 左子树
        levelOrder(Node.left, level - 1);

        // 右子树
        levelOrder(Node.right, level - 1);
    }
    /**
     * 求树高
     * 递归
     */
    public int depth(TreeNode Node) {
        if (Node == null) {
            return 0;
        }

        int l = depth(Node.left);
        int r = depth(Node.right);
        if (l > r) {
            return l + 1;
        } else {
            return r + 1;
        }
    }

    /**
     * 前序遍历
     * 非递归
     */
    public void preOrder1(TreeNode Node)
    {
        Stack<TreeNode> stack = new Stack<>();
        while(Node != null || !stack.empty())
        {
            while(Node != null)
            {
                //先访问根
                System.out.print(Node.val + "->");
                //根压栈
                stack.push(Node);
                //再去左子树，直到左子树没有为止
                Node = Node.left;
            }
            if(!stack.empty())
            {
                //弹栈
                Node = stack.pop();
                //去栈的右子树
                Node = Node.right;
            }
        }
    }

    /**
     * 中序遍历
     * 非递归
     */
    public void midOrder1(TreeNode Node)
    {
        Stack<TreeNode> stack = new Stack<>();
        while(Node != null || !stack.empty())
        {
            while (Node != null)
            {
                //压栈
                stack.push(Node);
                //去左子树，知道左子树为空
                Node = Node.left;
            }
            if(!stack.empty())
            {
                //弹栈
                Node = stack.pop();
                //访问
                System.out.print(Node.val + "->");
                //再去右子树
                Node = Node.right;
            }
        }
    }

    /**
     * 后序遍历
     * 非递归
     */
    public void posOrder1(TreeNode Node)
    {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while(Node != null || !stack1.empty())
        {
            while (Node != null)
            {
                //根压栈
                stack1.push(Node);
                //压如深度个数的0
                stack2.push(0);
                //去左子树,知道左子树为空
                Node = Node.left;
            }

            while(!stack1.empty() && stack2.peek() == 1)
            {
                //如果左右子树遍历完成，弹出标志1
                stack2.pop();
                //访问根节点
                System.out.print(stack1.pop().val + "->");
            }

            if(!stack1.empty())
            {
                //左子树已经遍历完成，弹0压1
                stack2.pop();
                stack2.push(1);
                Node = stack1.peek();
                //去右子树
                Node = Node.right;
            }
        }
    }

    /**
     * 层序遍历
     * 非递归
     */
    public void levelOrder1(TreeNode Node) {
        if (Node == null) {
            return;
        }

        TreeNode binaryNode;
        Queue<TreeNode> queue = new LinkedList<>();
        //根节点入队
        queue.add(Node);

        while (queue.size() != 0) {
            //根节点出队
            binaryNode = queue.poll();
            //访问
            System.out.print(binaryNode.val + "->");

            if (binaryNode.left != null) {
                //左子树入队
                queue.offer(binaryNode.left);
            }
            if (binaryNode.right != null) {
                //右子树入队
                queue.offer(binaryNode.right);
            }
        }
    }
}
