package P101TO150.P138;

public class P138 {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
    public Node copyRandomList(Node head) {
        cloneNode(head);
        connectRandom(head);
        return split(head);
    }
    //克隆链表至两倍长
    private void cloneNode(Node pHead){
        Node p = pHead;
        while(p!=null){
            Node pclone = new Node();
            pclone.val = p.val;
            pclone.next = p.next;
            p.next = pclone;
            p = pclone.next;
        }
    }
    //顺序遍历赋值random指针
    private void connectRandom(Node pHead){
        Node p = pHead;
        while(p!=null){
            Node pclone = p.next;
            if(p.random!=null){
                pclone.random = p.random.next;
            }
            p = pclone.next;
        }
    }
    //拆分链表
    private Node split(Node pHead){
        Node p = pHead;
        Node pcloneHead = null;
        Node pcloneNode = null;
        if(p!=null){
            pcloneHead = pcloneNode = p.next;
            p.next = pcloneNode.next;
            p = p.next;
        }
        while(p!=null){
            pcloneNode.next = p.next;
            pcloneNode = pcloneNode.next;
            p.next = pcloneNode.next;
            p = p.next;
        }
        return pcloneHead;
    }
}
