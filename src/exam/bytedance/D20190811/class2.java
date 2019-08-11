package exam.bytedance.D20190811;

import java.util.Scanner;

public class class2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        String s = sc.next();
        if(K<2){
            System.out.print(s);
            return;
        }
        char[] sarr = s.toCharArray();
        char[] result = new char[N];
        result[0] = sarr[0];
        int last = result[0]-'0';
        for (int i = 1; i < N; i++) {
            int cur = sarr[i]-'0';
            int curi = cur^(last);
            result[i] = (char)(curi+'0');
            int start = 0;
            if(i-K+2>=0){
                start = i-K+2;
            }else {
                start = 0;
            }
            last = xor(result,start,i);
        }

        System.out.print(new String(result));
    }
    public static int xor(char[] arr,int i,int j){
        if(i==j){
            return arr[i]-'0';
        }
        int rt = arr[i]-'0';
        for (int k = i+1; k <= j; k++) {
            rt = rt^(arr[k]-'0');
        }
        return rt;
    }
}
