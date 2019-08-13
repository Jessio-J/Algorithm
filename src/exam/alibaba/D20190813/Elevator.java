package exam.alibaba.D20190813;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

class Solve {
    class Elevator{
        //电梯当前所在层数
        int curFloor;
        //当前电梯人数
        int curPeople;
        int state;//向上行驶-1，向下行驶-2，静止状态-0
        Queue<Order> targetFloor = new PriorityQueue<>();
        public int getCurPeople() {
            return curPeople;
        }

        public void setCurPeople(int curPeople) {
            this.curPeople = curPeople;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public int getCurFloor() {
            return curFloor;
        }

        public void setCurFloor(int curFloor) {
            this.curFloor = curFloor;
        }
    }

    static class Order{
        //目标方向
        int direction;
        //请求者所在层
        int curFloor;
        //目标层
        int targetFloor;

        public int getTargetFloor() {
            return targetFloor;
        }

        public void setTargetFloor(int targetFloor) {
            this.targetFloor = targetFloor;
        }

        public int getDirection() {
            return direction;
        }

        public void setDirection(int direction) {
            this.direction = direction;
        }

        public int getCurFloor() {
            return curFloor;
        }

        public void setCurFloor(int curFloor) {
            this.curFloor = curFloor;
        }
    }

    static Elevator[] elevators;

    static Queue<Order> orders;

    public static void initElevator(){
        elevators = new Elevator[4];
        orders = new ConcurrentLinkedQueue<>();
    }

    public static void main(String[] args) {
        Thread user = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    Order order = new Order();
                    order.curFloor = 1;
                    order.direction = 1;
                    orders.offer(order);
                }

            }
        });
        user.start();

        Thread calc = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    Order order = orders.poll();
                    int direction = order.getDirection();
                    int curFloor = order.getCurFloor();
                    int minTime = Integer.MAX_VALUE;
                    int chooseElevator = 0;
                    for (int i = 0; i < 4; i++) {
                        //判断接受该请求后不会超载
                        if(elevators[i].getCurPeople()+1<=20){
                            //静止状态
                            int curMin = Integer.MAX_VALUE;
                            if(elevators[i].getState() == 0){
                                curMin = Math.abs(elevators[i].getCurFloor()-curFloor);
                            }
                            //电梯运行状态
                            if(elevators[i].getState() == direction){
                                //电梯和请求之后顺路才会进行计算
                                if(direction == 1&&elevators[i].getCurFloor()<curFloor||direction == 2&&elevators[i].getCurFloor()>curFloor){
                                    curMin = Math.abs(elevators[i].getCurFloor()-curFloor);
                                }
                            }
                            //当前时间比之前计算的最小时间小，则由当前电梯进行处理
                            if(curMin<minTime){
                                minTime = curMin;
                                chooseElevator = i+1;
                            }
                        }
                    }
                    //将order加入电梯的目标停靠列表中
                    if(chooseElevator!=0){
                        elevators[chooseElevator-1].targetFloor.offer(order);
                        if(elevators[chooseElevator-1].getState()==0){
                            elevators[chooseElevator-1].setState(direction);
                        }

                    }
                }

            }
        });
        calc.start();

        Thread elemove = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                    for (int i = 0; i < 4; i++){
                        if(elevators[i].targetFloor.size()!=0){
                            Order order= elevators[i].targetFloor.poll();
                            elevators[i].setCurPeople(elevators[i].getCurPeople()+1);
                            //执行指令让电梯移动
                            //电梯运行
                            //电梯到达目的地
                            elevators[i].setCurFloor(order.getTargetFloor());
                            elevators[i].setCurPeople(elevators[i].getCurPeople()-1);
                        }


                    }
            }
        });
        elemove.start();
    }
}
