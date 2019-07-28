package exam;

import exam.shopee.D20190727.class3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class standardio {
    //内部ListNode类
    public static class ListNode {
        public int val;
        public class3.ListNode next;
        public ListNode(int x) { val = x; }
    }


    public static void main(String[] args) {
        read6();
    }

    /**
     * 读取一行定长数字到数组中
     *     //itar:数组for循环
     *     //itli:链表for循环
     *     //iter:迭代器循环
     *     //itve:vector数组循环
     */
    public static void read1() {
        //========
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        //========
    }


    /**
     * 读取一行不定长数字到数组中
     */
    public static void read2(){
        //========
        Scanner sc = new Scanner(System.in);
        String tmpstr = sc.nextLine();
        String[] tmpstrarr = tmpstr.trim().split(" ");
        int[] nums = new int[tmpstrarr.length];
        for(int i = 0;i<tmpstrarr.length;i++){
            nums[i] = Integer.parseInt(tmpstrarr[i]);
        }
        //========
    }

    /**
     * 读取多行确定个数的数字
     */
    public static void read3() {
        //========
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] nums = new int[m][n];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        //========
    }

    /**
     * 读取不确定行数的内容
     */
    public static void read4() {
        Scanner sc = new Scanner(System.in);
        List<String> strings = new ArrayList<>();
        while (true){
            String str = sc.nextLine();
            if(str!=null&&str.length()!=0){
                strings.add(str);
            }else {
                break;
            }
        }
        System.out.println(strings);
    }
    /**
     * 读取不确定行数的内容,方法二
     */
    public static void read5() {
        Scanner sc = new Scanner(System.in);
        List<String> strings = new ArrayList<>();
        String s = null;
        while (!(s = sc.nextLine()).equals("")){
            strings.add(s);
        }
        System.out.println(strings);
    }
    /**
     * 读取不确定行数的内容,方法三hasNextLine
     */
    public static void read6() {
        Scanner sc = new Scanner(System.in);
        List<String> strings = new ArrayList<>();
        while (sc.hasNextLine()){
            strings.add(sc.nextLine());
        }
        System.out.println(strings);
    }

}
