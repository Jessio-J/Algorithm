package exam.huawei.D20180814;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class class2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] arr = line.split(",");
        List<String> sList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String tmp = "";
            if(!arr[i].equals("")){
                if(arr[i].charAt(0)=='\"'&&check(arr[i])){
                    tmp += (arr[i].substring(1,arr[i].length()).replaceAll("\"\"","\"")+",");
                    while (++i<arr.length&&!check(arr[i])){
                        tmp += (arr[i].replaceAll("\"\"","\"")+",");
                    }
                    tmp += arr[i].substring(0,arr[i].length()-1).replaceAll("\"\"","\"");
                }else if(arr[i].charAt(0)=='"'&&arr[i].charAt(arr[i].length()-1)=='\"'){
                    tmp = arr[i].substring(1,arr[i].length()-1).replaceAll("\"\"","\"");
                }else {
                    tmp = arr[i];
                }
            }

            sList.add(tmp);
        }
        System.out.println(sList.size());
        for (String s : sList) {
            if(s.equals("")){
                System.out.println("--");
            }else {
                System.out.println(s);
            }
        }

    }
    public static boolean check(String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
             if(s.charAt(i)=='\"'){
                 count++;

             }

        }
        if((count&1)==1){
            return true;
        }else {
            return false;
        }
    }
}
