package P101TO150.P102;

import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//思想：队列实现层次遍历，层次输出，这里用length记录了每一层的个数
public class P102_4 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int length = 1;
        while(!queue.isEmpty()){
            List<Integer> subList = new ArrayList<>();
            for(int i=0;i<length;i++){
                TreeNode t = queue.poll();
                if(t==null){
                    continue;
                }
                subList.add(t.val);
                if(t.left!=null){
                    queue.add(t.left);
                }
                if(t.right!=null){
                    queue.add(t.right);
                }
            }
            list.add(subList);
            length=queue.size();
        }
        return list;
    }
}
