package exam.bytedance.D20190811;

import java.util.*;

public class class1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Clock> clocks = new ArrayList<>(); 
        for (int i = 0; i < N; i++) {
            Clock clock = new Clock(sc.nextInt(), sc.nextInt());
            clocks.add(clock);
        }
        int X = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        Collections.sort(clocks, (o1, o2) -> {
            if(o1.h<o2.h)return -1;
            if(o1.h>o2.h)return 1;
            if(o1.m<o2.m)return -1;
            if(o1.m>o2.m)return 1;
            return 0;
        });
        int rA = clocks.get(0).h;
        int rB = clocks.get(0).m;
        for (int i = 1; i < clocks.size(); i++) {
            int tmpA = clocks.get(i).h;
            int tmpB = 0;
            int add = clocks.get(i).m+X>=60?1:0;

            if(add==1){
                tmpB = clocks.get(i).m+X-60;
                tmpA++;
            }else {
                tmpB = clocks.get(i).m+X;
            }
            if(comp(new Clock(tmpA,tmpB),new Clock(A,B))<0){
                rA = tmpA;
                rB = tmpB;
            }else {
                break;
            }
        }
        System.out.print(rA+" "+rB);
    }
    static class Clock{
        int h;
        int m;

        public int getH() {
            return h;
        }

        public void setH(int h) {
            this.h = h;
        }

        public int getM() {
            return m;
        }

        public void setM(int m) {
            this.m = m;
        }

        public Clock(int h, int m) {
            this.h = h;
            this.m = m;
        }
    }
    public static int comp(Clock o1,Clock o2){
        if(o1.h<o2.h)return -1;
        if(o1.h>o2.h)return 1;
        if(o1.m<o2.m)return -1;
        if(o1.m>o2.m)return 1;
        return 0;
    }
}
