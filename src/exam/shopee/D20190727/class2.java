package exam.shopee.D20190727;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class class2 {
    static List<List<Integer>> rList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int target = scanner.nextInt();
        int[] arr = new int[n];
        if(n==0){
            return;
        }
        for(int i = 0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        recursion(arr,0,0,target,new ArrayList<>());
        System.out.print(rList.size());

    }
    public static void recursion(int[] candi,int index,int lastSum,int target,List<Integer> list){
        for(int i = index+1;i<candi.length;i++){
            if(lastSum+candi[i]<=target){
                List<Integer> listCur = new ArrayList<>(list);
                listCur.add(candi[i]);
                recursion(candi,i,lastSum+candi[i],target,listCur);
            }else if(lastSum+candi[i]>target){
                break;
            }
        }
        if(lastSum==target){
            rList.add(list);
        }
    }
}
