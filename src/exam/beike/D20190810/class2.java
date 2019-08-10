package exam.beike.D20190810;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class class2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNext()){
            list.add(sc.nextInt());
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        if(nums.length==0||nums==null){
            System.out.println("0");
            return;
        }
        int len = nums.length;
        int sublongest[] = new int[len];
        sublongest[0] = 1;
        int longest = 1;
        for (int i = 1; i < len; i++) {
            int sublong = 0;
            for (int j = 0; j < i; j++) {
                if(nums[j]<=nums[i]){
                    sublong = Math.max(sublongest[j],sublong);
                }

            }
            sublongest[i] = sublong +1;
            longest = Math.max(sublongest[i],longest);
        }
        System.out.println(""+longest);
    }
}
