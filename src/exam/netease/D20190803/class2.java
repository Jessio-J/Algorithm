package exam.netease.D20190803;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class class2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        for (int k = 0; k < m; k++) {
        int n = scanner.nextInt();
        int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();

            }
        permute(arr);
        boolean falgall = false;
        for (List<Integer> ilist :list) {
            boolean flag = true;
            for(int i =0;i<ilist.size();i++){
                if(i==0){
                    if(ilist.get(0)>=(ilist.get(1)+ilist.get(ilist.size()-1))){
                        flag = false;
                    }
                }else if (i==ilist.size()-1){
                    if(ilist.get(ilist.size()-1)>=(ilist.get(0)+ilist.get(ilist.size()-2))){
                        flag = false;
                    }
                }else {
                    if(ilist.get(i)>=(ilist.get(i-1)+ilist.get(i+1))){
                        flag = false;
                    }
                }
            }
            if(flag==true){
                System.out.println("YES");
                falgall = true;
                break;
            }

        }
        if (falgall==false){
            System.out.println("NO");
        }

        }

    }

        public static void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        /**
         * 全排列函数
         *
         * @param nums
         * @param p    起始位置
         * @param q    结束位置（include）
         */
        public static void perm(int[] nums, int p, int q) {

            if (p == q) {
                List<Integer> values = new ArrayList<>();
                for (int i = 0; i < nums.length; i++) {
                    values.add(nums[i]);
                }
                list.add(values);
            }else if(p < q){
                for (int i = p; i <= q; i++) {
                    swap(nums, p, i);
                    perm(nums, p + 1, q);
                    swap(nums, p, i);
                }

            }
        }

        static List<List<Integer>> list = new ArrayList<>();

        public static List<List<Integer>> permute(int[] nums) {
            list.clear();
            perm(nums, 0, nums.length - 1);
            return list;
        }


}
