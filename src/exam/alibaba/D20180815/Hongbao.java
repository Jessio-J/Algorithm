package exam.alibaba.D20180815;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hongbao {
    //说明：就我个人的生活经验来看，一般是会对个红包的最小额度和所发红包的最大额度进行一个限额的
    //单个最小红包额度
    private static final double min = 0.01;
    //最大红包额度
    private static final double max = 200;

    //1-产生随机红包
    public static List<Double> generateHongbao(double money, int count) {
        //1.1-验证红包的输入值是否合法
        if (!check(money, count)) {
            return null;
        }
        List<Double> list = new ArrayList<Double>();
        //1.2-如果只发出一个红包，则直接返回
        if(count==1){
            list.add(money);
            return list;
        }
        //1.3-根据题目要求，最佳手气金额不能超过最大金额的90%
        double max = money * 0.9;

        //1.4-我们先对前count-1个红包进行生成，保证这些随机数都不大于最大金额的90%
        for (int i = 0; i < count-1; i++) {
            double one = Math.random() * (max - min) + min;
            list.add(one);
            money -= one;
        }
        //1.5-最后检查最后一个红包的大小是否符合不大于最大金额的90%
        if(money>max){
            //1.5.1-如果该红包超过最大限额，则设该红包的值为上限max
            double feed = (money-max)/count-1;
            //1.5.2-我们对多出的部分，均匀的补偿到红包队列中原来的红包中去
            for(int i =0;i<list.size();i++){
                list.set(i,list.get(i)+feed);
            }
            list.add(money);
        }else {
            //1.5.3-如果该红包不超过最大限额，直接将其加入红包队列
            list.add(money);
        }
        return list;
    }

    //2-检查输入红包值是否合法
    private static boolean check(double money, int count) {
        //2.1-判断是否满足红包个数*最小值 大于红包总价值
        if (count*min > money) {
            return false;
        }
        //2.2-判断红包总价值是否超出系统红包限额最大值
        if (money > max) {
            return false;
        }
        return true;
    }
    //3-对生成的红包队列进行输出
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double money = sc.nextDouble();
        int count = sc.nextInt();
        List<Double> hongbaoList = generateHongbao(money, count);
        for (int i = 0;i<hongbaoList.size();i++) {
            System.out.println("第"+i+"个人的红包为："+hongbaoList.get(i));
        }
    }
}
