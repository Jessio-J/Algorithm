import P51TO100.P55.P55_JumpGame3;
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
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
//        new P37_SudokuSolver3().solveSudoku(board);
//        new P48_RotateImage().rotate(matrix);
        System.out.println("answer:"+new P55_JumpGame3().canJump(new int[]{1,1,1,0,0,4}));
    }
}
