package datastruct;

public class TreeLinkNode {
    public int val;
    public TreeLinkNode left = null;
    public TreeLinkNode right = null;
    //中序遍历中指向父节点的指针
    public TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
