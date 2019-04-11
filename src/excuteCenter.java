
import P38.P38_CountAndSay;
import P39.P39_CombinationSum;
import P40.P40_CombinationSumII;
import P41.P41_FirstMissingPositive;
import P42.P42_TrappingRainWater;
import datastruct.ListNode;


public class excuteCenter {
    public static void main(String[] args){
//        int one = '1';
//        int zero = '0';
//        int nine = '9';
//        int minors = '-';
//        int blank = ' ';
//        String a = "    -54 miv 3677  ga;";
//        int plus = '+';
//        String[] array = a.split(" ");
//        System.out.println("1:"+one+"\n0:"+zero+"\n9:"+nine+"\n-:"+minors+"\nblank:"+blank+"\nplus:"+plus);
//        byte[] buffer = new byte[]{0x0A};
//        int percent = Integer.valueOf("" + (buffer[0]&0xff) ,10);
        ListNode head = new ListNode(1);
        ListNode p = new ListNode(2);
        head.next = p;
        for(int i = 3;i<=5;i++){
            ListNode q = new ListNode(i);
            p.next = q;
            p = p.next;
        }
//        new P31_NextPermutation().nextPermutation(new int[]{1,3,2});
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'},
                };
//        new P37_SudokuSolver3().solveSudoku(board);
        System.out.println("answer:"+new P42_TrappingRainWater().trap(new int[]{5,2,1,2,1,5}));
    }
}
