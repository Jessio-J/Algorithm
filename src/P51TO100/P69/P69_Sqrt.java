package P51TO100.P69;

public class P69_Sqrt {
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }else if(x== 1){
            return 1;
        }else if(x==2){
            return 1;
        }else if(x==3){
            return 1;
        }else if(x==4){
            return 2;
        }
        int r = 0;
        //累加去试
        while(r*r<=x&&r<=46340){
            r++;
        }
        return r-1;
    }
}
