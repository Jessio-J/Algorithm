package jianzhiOffer.P21;

import java.util.Arrays;

public class P21_2 {
    public void reOrderArray(int[] array) {
        int oddc = 0;
        int evenc = 0;
        for (int i = 0; i < array.length; i++) {
            if((array[i]&1)==0){
                evenc++;
            }else {
                oddc++;
            }
        }
        int[] odd = new int[oddc];
        int[] even = new int[evenc];
        int o = 0;
        int e = 0;
        for(int i = 0; i < array.length; i++) {
            if((array[i]&1)==0){
                even[e] = array[i];
                e++;
            }else {
                odd[o] = array[i];
                o++;
            }
        }
        System.arraycopy(odd,0,array,0,oddc);
        System.arraycopy(even,0,array,oddc,evenc);
    }
}
