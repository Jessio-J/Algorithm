package exam.dji.D20190806;

import java.util.HashMap;
import java.util.Scanner;

public class class2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            String str = scanner.nextLine();
            if(str!=null&&str.length()!=0){
                String[] nm = str.split(" ");
                int n = Integer.parseInt(nm[0]);
                int m = Integer.parseInt(nm[1]);
                HashMap<String, String> map = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    String[] line = scanner.nextLine().split(" ");
                    map.put(line[0],line[1]);
                }
                for (int i = 0; i < m; i++) {
                    System.out.println(map.get(scanner.nextLine()));
                }
            }else {
                break;
            }
        }
    }
}
