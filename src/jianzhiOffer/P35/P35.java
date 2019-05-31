package jianzhiOffer.P35;

import datastruct.RandomListNode;

public class P35 {
    public RandomListNode Clone(RandomListNode pHead) {
        cloneNode(pHead);
        connectRandom(pHead);
        return split(pHead);
    }
    //克隆链表至两倍长
    private void cloneNode(RandomListNode pHead){
        RandomListNode p = pHead;
        while(p!=null){
            RandomListNode pclone = new RandomListNode(p.label);
            pclone.next = p.next;
            p.next = pclone;
            p = pclone.next;
        }
    }
    //顺序遍历赋值random指针
    private void connectRandom(RandomListNode pHead){
        RandomListNode p = pHead;
        while(p!=null){
            RandomListNode pclone = p.next;
            if(p.random!=null){
                pclone.random = p.random.next;
            }
            p = pclone.next;
        }
    }
    //拆分链表
    private RandomListNode split(RandomListNode pHead){
        RandomListNode p = pHead;
        RandomListNode pcloneHead = null;
        RandomListNode pcloneNode = null;
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
