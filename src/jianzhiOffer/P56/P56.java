package jianzhiOffer.P56;

public class P56 {
    public void FindNumsAppearOnce(int[] data, int num1[], int num2[]) {
        if (data.length < 2)
            return;
        int size = data.length;
        int temp = data[0];
        for (int i = 1; i < size; i++)
            temp = temp ^ data[i];
        if (temp == 0)
            return;
        int index = 0;
        while ((temp & 1) == 0) {
            temp = temp >> 1;
            ++index;
        }
        num1[0] = 0;
        num2[0] = 0;
        //分组
        for (int i = 0; i < size; i++) {
            if (IsBit(data[i], index))
                num1[0] ^= data[i];
            else
                num2[0] ^= data[i];
        }
    }

    boolean IsBit(int num, int index) {
        num = num >> index;
        return (num & 1) == 1 ? true : false;
    }
}
