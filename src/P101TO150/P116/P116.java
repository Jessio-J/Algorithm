package P101TO150.P116;

import datastruct.Node;
import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P116 {
    public Node connect(Node root) {
        if(root==null){
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int length = 1;
        while(!queue.isEmpty()){
            Node pre = null;
            for(int i=0;i<length;i++){
                Node t = queue.poll();
                if(pre!=null){
                    pre.next = t;
                }
                pre = t;
                if(i==length-1){
                    t.next = null;
                }
                if(t.left!=null){
                    queue.add(t.left);
                }
                if(t.right!=null){
                    queue.add(t.right);
                }
            }
            length=queue.size();
        }
        return root;
    }

}
