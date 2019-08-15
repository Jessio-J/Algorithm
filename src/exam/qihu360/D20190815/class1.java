package exam.qihu360.D20190815;

import java.util.*;

public class class1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] num1 = new int[n];
        int[] num2 = new int[n];
        for (int i = 0; i < num1.length; i++) {
            num1[i] = sc.nextInt();
        }
        for (int i = 0; i < num2.length; i++) {
            num2[i] = sc.nextInt();
        }
        List<List<Integer>> res1 = new ArrayList<>();
        List<List<Integer>> res2 = new ArrayList<>();
        dfs(res1, num1, 0);
        dfs(res2, num2, 0);
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> integers1 : res1) {
            for (List<Integer> integers2 : res2) {
                List<Integer> tmp = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    tmp.add((integers1.get(i)+integers2.get(i))%m);
                }
                result.add(tmp);
            }
        }
        Collections.sort(result, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int rt = 0;
                for (int i = 0; i < o1.size(); i++) {
                    if(o1.get(i)<o2.get(i)){
                        rt = 1;
                        break;
                    }else if(o1.get(i)>o2.get(i)){
                        rt = -1;
                        break;
                    }else {
                        continue;
                    }

                }
                return rt;
            }
        });
        List<Integer> max = result.get(0);
        for (int i = 0; i <max.size()-1; i++) {
            System.out.print(max.get(i)+" ");

        }
        System.out.print(max.get(max.size()-1));
    }

    public static void dfs(List<List<Integer>> res, int[] nums, int cur) {
        int[] newNums = Arrays.copyOf(nums, nums.length);
        if (cur == newNums.length) {
            List<Integer> temp = new ArrayList<>();
            for (Integer item : newNums) temp.add(item);
            res.add(temp);
        } else{
            for (int i = cur; i < newNums.length; i++) {
                if (cur != i && newNums[i] == newNums[cur]) continue; //去重
                swap(newNums, cur, i);
                dfs(res, newNums, cur + 1);
//            swap(newNums,cur,i); //不能交换 不然也不能去重
            }
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
