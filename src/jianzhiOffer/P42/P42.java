package jianzhiOffer.P42;

public class P42 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int res = array[0];
        int sum = 0;
        for (int num : array) {
            if (sum > 0)
                //sum值大于0，则有可能加上本num后
                sum += num;
            else
                //sum值小于0，则重新从本num开始计算
                sum = num;
            //比较加上本num和不加本num哪个大
            res = Math.max(res, sum);
        }
        return res;
    }
}
