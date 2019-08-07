package exam.dji.D20190806;

import java.util.Scanner;

public class class1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for (int i = 0; i < cases; i++) {
            int N = scanner.nextInt();
            int X = scanner.nextInt();
            int[] arrv = new int[N+1];
            int[] arrx = new int[N+1];
            int[][] dp = new int[N+1][X+1];
            for (int a = 1; a <= N; a++) {
                arrv[a] = scanner.nextInt();
                arrx[a] = scanner.nextInt();

            }
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= X; k++) {
                    if(k<arrx[j]){
                        dp[j][k] = dp[j-1][k];
                    }else {
                        dp[j][k] = Math.max(dp[j-1][k],dp[j-1][k-arrx[j]]+arrv[j]);
                    }

                }

            }
            System.out.println(dp[N][X]);

        }

    }
}
