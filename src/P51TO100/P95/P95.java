package P51TO100.P95;

import datastruct.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class P95 {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> rList = new ArrayList<>();
        if(n<1){
            return rList;
        }
        for(int i = 1;i<=n;i++){
            if(i==1){
                rList.add(new TreeNode(1));
            }else {
                List<TreeNode> tmp = new ArrayList<>();
                tmp.addAll(rList);
                rList.clear();
                for(TreeNode root : tmp){
                    //直接插在原树头部
                    TreeNode newTree1 = copyTrees(root);
                    TreeNode newroot = new TreeNode(i);
                    newroot.left = newTree1;
                    rList.add(newroot);
                    //循环插入原树的右子树上
                    TreeNode p = root;
                    while(p!=null){
                        TreeNode newTree2 = copyTrees(root);
                        TreeNode q = newTree2;
                        while(q.val!=p.val){
                            q = q.right;
                        }
                        TreeNode newi = new TreeNode(i);
                        newi.left = q.right;
                        q.right = newi;
                        rList.add(newTree2);
                        p = p.right;
                    }
                }
            }
        }
        return rList;
    }
    private TreeNode copyTrees(TreeNode root1){
        if(root1==null){
            return null;
        }
        TreeNode newNode = new TreeNode(root1.val);
        newNode.left = copyTrees(root1.left);
        newNode.right = copyTrees(root1.right);
        return newNode;
    }
}
