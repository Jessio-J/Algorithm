package P51TO100.P85;

//会造成整形、长整形溢出
public class P85_2 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        long[] nums = new long[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            nums[i] = Long.parseLong(new String(matrix[i]), 2);
        }
        int ans = 0;
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            int j = i;
            long num = nums[i];
            while (j < N) {
                num &= nums[j];
                if (num == 0) {
                    break;
                }
                int l = 0;
                long curnum = num;
                while (curnum != 0) {
                    l += 1;
                    curnum = curnum & (curnum << 1);
                }
                ans = Math.max(ans, l * (j - i + 1));
                j++;
            }
        }
        return ans;
    }
}
