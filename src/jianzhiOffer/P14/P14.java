package jianzhiOffer.P14;
//动态规划
public class P14 {
    public int maxProductCutting(int length){
        if(length<2)
            return 0;
        if (length==2)
            return 1;
        if(length==3)
            return 2;
        int[] p = new int[length+1];
        p[0] = 0;
        p[1] = 1;
        p[2] = 2;
        p[3] = 3;
        for(int i=4;i<=length;i++){
            int max = 0;
            for(int j = 1;j<=(i>>1);j++){
                int pt = p[j]*p[i-j];
                if(max<pt)
                    max = pt;
            }
            p[i] = max;
        }
        return p[length];
    }
}
