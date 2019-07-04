package jianzhiOffer.P37;

import datastruct.TreeNode;

public class P37 {
    String result = "";
    int index = 0;
    public String Serialize(TreeNode root) {
        getSerialize(root);
        return result;
    }
    private void getSerialize(TreeNode root){
        if(root==null){
            result +="$,";
            return;
        }
        result+=root.val+",";
        getSerialize(root.left);
        getSerialize(root.right);
    }
    public TreeNode Deserialize(String str) {
        index = 0;
        String[] strs = str.split(",");
        return getDeserialize(strs);
    }
    private TreeNode getDeserialize(String[] strs){
        if(index<strs.length-1){
            if(strs[index].equals("$")){
                ++index;
                return null;
            }else {
                TreeNode node = new TreeNode(Integer.parseInt(strs[index]));
                ++index;
                node.left = getDeserialize(strs);
                node.right = getDeserialize(strs);
                return node;
            }
        }
        else {
            return null;
        }
    }
}
