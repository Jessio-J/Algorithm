package P51TO100.p67;
//使用StringBuilder来做
public class P67_AddBinary2 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0 || flag == 1) {
            int ia = i >= 0 ? a.charAt(i) == '1' ? 1 : 0 : 0;
            int ib = j >= 0 ? b.charAt(j) == '1' ? 1 : 0 : 0;
            int sum = ia + ib + flag;
            switch (sum) {
                case 0:
                    sb.append(0);
                    break;
                case 1:
                    sb.append(1);
                    flag = 0;
                    break;
                case 2:
                    sb.append(0);
                    flag = 1;
                    break;
                case 3:
                    sb.append(1);
                    flag = 1;
                    break;
            }
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}
