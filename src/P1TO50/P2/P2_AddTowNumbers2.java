package P1TO50.P2;//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
//        如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
//        您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//        示例：
//
//        输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//        输出：7 -> 0 -> 8
//        原因：342 + 465 = 807

/**
 * Definition for singly-linked list.
 * public class P1TO50.P2.ListNode {
 *     int val;
 *     P1TO50.P2.ListNode next;
 *     P1TO50.P2.ListNode(int x) { val = x; }
 * }
 */
public class P2_AddTowNumbers2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        int rest = 0;
        while (l1 != null || l2 !=null){
            int val1 = 0,val2 = 0;
            if(l1!=null){
                val1 = l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                val2 = l2.val;
                l2 = l2.next;
            }
            ListNode pi = new ListNode((val1+val2+rest)%10);
            rest = (val1+val2+rest)/10;
            p.next = pi;
            p = pi;
        }
        if(rest != 0 ){
            p.next = new ListNode(rest);
        }
        return head.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(5);
//        ListNode l11 = l1.next = new P1TO50.P2.ListNode(4);
//        l11.next = new P1TO50.P2.ListNode(3);
        ListNode l2 = new ListNode(5);
//        ListNode p2 = l2;
//        for(int i = 0;i<9;i++){
//            p2.next = new ListNode(9);
//            p2 = p2.next;
//        }
//        ListNode l22 = l2.next = new P1TO50.P2.ListNode(6);
//        l22.next = new P1TO50.P2.ListNode(4);
        P2_AddTowNumbers2 calc = new P2_AddTowNumbers2();
        ListNode l3 = calc.addTwoNumbers(l1,l2);
        while (l3!= null){
            System.out.print(""+l3.val+"->");
            l3 = l3.next;
        }
    }
}
//class Solution {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
////        ListNode head = null;
//        ListNode p = null;
//        ListNode head = p;
//        int rest = 0;
//        while (l1 != null || l2 !=null){
//            int val1 = 0,val2 = 0;
//            if(l1!=null){
//                val1 = l1.val;
//                l1 = l1.next;
//            }
//            if(l2!=null){
//                val2 = l2.val;
//                l2 = l2.next;
//            }
//            p = new ListNode((val1+val2)%10+rest);
//            rest = (val1+val2+rest)/10;
//            p = p.next;
//        }
//        return head;
//    }
//}
//
//class MainClass {
//    public static int[] stringToIntegerArray(String input) {
//        input = input.trim();
//        input = input.substring(1, input.length() - 1);
//        if (input.length() == 0) {
//            return new int[0];
//        }
//
//        String[] parts = input.split(",");
//        int[] output = new int[parts.length];
//        for(int index = 0; index < parts.length; index++) {
//            String part = parts[index].trim();
//            output[index] = Integer.parseInt(part);
//        }
//        return output;
//    }
//
//    public static ListNode stringToListNode(String input) {
//        // Generate array from the input
//        int[] nodeValues = stringToIntegerArray(input);
//
//        // Now convert that list into linked list
//        ListNode dummyRoot = new ListNode(0);
//        ListNode ptr = dummyRoot;
//        for(int item : nodeValues) {
//            ptr.next = new ListNode(item);
//            ptr = ptr.next;
//        }
//        return dummyRoot.next;
//    }
//
//    public static String listNodeToString(ListNode node) {
//        if (node == null) {
//            return "[]";
//        }
//
//        String result = "";
//        while (node != null) {
//            result += Integer.toString(node.val) + ", ";
//            node = node.next;
//        }
//        return "[" + result.substring(0, result.length() - 2) + "]";
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            ListNode l1 = stringToListNode(line);
//            line = in.readLine();
//            ListNode l2 = stringToListNode(line);
//
//            ListNode ret = new Solution().addTwoNumbers(l1, l2);
//
//            String out = listNodeToString(ret);
//
//            System.out.print(out);
//        }
//    }
//}
//
