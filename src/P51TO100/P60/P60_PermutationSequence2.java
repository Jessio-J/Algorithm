package P51TO100.P60;

public class P60_PermutationSequence2 {
    public String getPermutation(int n, int k) {
        char[] arr = new char[n];
        //第1个排列
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = (char) (i + '0');
        }

        int cur = 0;
        int remain = k - 1;
        while (remain > 0) {
            int step = getFactorial(n - cur - 1);
            int loop = remain / step;

            for (int i = 1; i <= loop; i++) {
                char tmp = arr[cur];
                arr[cur] = arr[cur + i];
                arr[cur + i] = tmp;
            }

            remain = remain % step;
            cur++;
        }

        return new String(arr);
    }
    private int getFactorial(int n) {
        int ret = 1;
        for (int i = 2; i <= n; i++) {
            ret *= i;
        }
        return ret;
    }
}
