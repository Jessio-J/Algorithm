package jianzhiOffer.P61;

public class P61 {
    public boolean isContinuous(int[] numbers) {
        int[] flag = new int[14];
        for (int i = 0; i < numbers.length; i++) {
            flag[numbers[i]]++;
        }
        //找到最小的牌
        int index = 1;
        for (; index <= 9; index++) {
            if (flag[index] > 1) {
                return false;
            } else if (flag[index] == 1) {
                break;
            }
        }
        //调整
        if (flag[index] == 1) {
            for (int j = index + 1; j <= 13; j++) {
                if (flag[j] == 0 && flag[0] > 0) {
                    flag[0]--;
                    flag[j]++;
                }
            }
        } else {
            for (int j = 13; j >= 9; j--) {
                if (flag[j] == 0 && flag[0] > 0) {
                    flag[0]--;
                    flag[j]++;
                }
            }
        }
        //判断
        index = 1;
        for (; index <= 9; index++) {
            if (flag[index] > 1) {
                return false;
            } else if (flag[index] == 1) {
                break;
            }
        }
        if (flag[index] == 1) {
            for (int k = 0; k < 5; k++) {
                if (flag[index + k] != 1) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
