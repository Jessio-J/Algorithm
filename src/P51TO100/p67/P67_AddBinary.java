package P51TO100.p67;

public class P67_AddBinary {
    public String addBinary(String a, String b) {
        int rest = 0;
        int la = a.length();
        int lb = b.length();
        int len = Math.max(la,lb);
        int shor = Math.min(la,lb);
        String r = "";
        for(int i = 0;i<len;i++){
            int numa= 0;
            int numb =0;
            if(la-1-i>=0) {
                numa = a.charAt(la - 1 - i) - '0';
            }
            if(lb-1-i>=0){
                numb = b.charAt(lb-1-i)-'0';
            }
            int num = (numa+numb+rest)&1;
            rest = ((numa+numb+rest)&2)>>1;
            r = num+r;
        }

        return (rest>0?rest:"")+r;
    }
}
