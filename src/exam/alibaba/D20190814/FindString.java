package exam.alibaba.D20190814;

import java.util.*;

public class FindString  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //从输入流中长字符串
        String str = sc.next();
        String curstr = str;
        Map<String, Integer> strMap = new TreeMap<>();
        //1-找到这样的串
        for (int i = 2; i < curstr.length() - 2; i++) {
            boolean flag = false;
            //1.1-找到这样的长度为5的回文串
            for (int j = i - 1; j >= i - 2; j--) {
                if (str.charAt(j) == str.charAt(2 * i - j)) {
                    if (j == i - 2) {
                        flag = true;
                    } else {
                        continue;
                    }
                } else {
                    break;
                }
            }
            //1.2-flag为true代表找到这样的回文串
            if (flag == true) {
                //1.2.1-将map中相同频率的key的频率+1
                if (!strMap.containsKey(curstr.substring(i - 2, i + 3))) {
                    strMap.put(curstr.substring(i - 2, i + 3), 1);
                } else {
                    strMap.put(curstr.substring(i - 2, i + 3), 1 + strMap.get(curstr.substring(i - 2, i + 3)));
                }
                //1.2.2-重新编辑源字符串，作为新串
                curstr = curstr.substring(0, i - 2) + curstr.substring(i + 3, curstr.length());
                //1.2.3重新定位扫描指针，开始新串的扫描
                i = 1;
                continue;
            }
        }

        //2-排序操作
        List<Map.Entry<String, Integer>> list = new ArrayList<>(strMap.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        if (list.size() >= 10) {
            //2.1-结果集超过10个
            for (int i = 0; i < 10; i++) {
                System.out.println(list.get(i).getKey());

            }
        } else {
            //2.2-不足10个
            for (Map.Entry<String, Integer> stringIntegerEntry : list) {
                System.out.println(stringIntegerEntry.getKey());
            }
        }

    }
}
