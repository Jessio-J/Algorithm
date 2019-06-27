package jianzhiOffer.P50;

public class P50_2 {
    public void FindNumsAppearOnce(int[] data, int num1[], int num2[]) {
        if (data.length < 2)
            return;
        int size = data.length;
        int temp = data[0];
        //全部做一遍异或，结果相当于那两个只出现一次的数做了异或
        for (int i = 1; i < size; i++)
            temp = temp ^ data[i];
        if (temp == 0)
            return;
        int index = 0;
        //找出异或结果中第一次出现不同的低位
        while ((temp & 1) == 0) {
            temp = temp >> 1;
            ++index;
        }
        num1[0] = 0;
        num2[0] = 0;
        for (int i = 0; i < size; i++) {
            //对这两个只出现一次的数在不同的这一位上进行分组，所有数中这一位为0的一组，为1的一组
            //由于其他的数都出现了两次，所以异或完成之后结果就是那个只出现一次的数
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
