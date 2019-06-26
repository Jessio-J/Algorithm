package jianzhiOffer.P49;

public class P49 {
    public int GetUglyNumber_Solution(int index) {

        if(index<=0)
            return 0;
        int[] result = new int[index];
        int count = 0;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        result[0] = 1;
        int tmp = 0;
        while (count < index-1) {
            tmp = min(result[i2] * 2,result[i3] * 3, result[i5] * 5);
            if(tmp>=result[i2] * 2)
                i2++;//三条if防止值是一样的，不要改成else的
            if(tmp>=result[i3] * 3)
                i3++;
            if(tmp>=result[i5]*5)
                i5++;
            result[++count]=tmp;
        }
        return result[index - 1];

    }

    public int min(int x1, int x2, int x3) {
        int k = x1 < x2 ? x1 : x2;
        return x3 < k ? x3 : k;
    }
}

