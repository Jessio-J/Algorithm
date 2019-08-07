package exam.dji.D20190806;

import java.util.*;

public class class3 {
    static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            String str = scanner.nextLine();
            if(str!=null&&str.length()!=0){
                String[] vn = str.split(" ");
                int v = Integer.parseInt(vn[0]);
                int n = Integer.parseInt(vn[1]);
                List<Food> foodList = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    foodList.add(new Food(i,scanner.nextInt()));
                }
                int M = scanner.nextInt();
                for (int i = 0; i < M; i++) {
                    int id = scanner.nextInt();
                    Food fd = foodList.get(--id);
                    fd.setLike(i);
                }
                Collections.sort(foodList, (o1, o2) -> {
                    if(o1.getLike()>o2.getLike())return -1;
                    if(o1.getLike()<o2.getLike())return 1;
                    if(o1.getV()>o1.getV())return -1;
                    if(o1.getV()<o1.getV())return 1;
                    return 0;
                });
                count = 0;
                search(foodList,0,0,v);
                System.out.println(count);
            }else {
                break;
            }
        }

    }
    private static void search(List<Food> foodlist,int index,int curNum,int totalNum){
        if(curNum==totalNum){
            count++;
        }else if (curNum<totalNum) {
            if(index<foodlist.size()){
                for (int i = index; i < foodlist.size(); i++) {
                    Food fd = foodlist.get(i);
                    if(fd.getV()+curNum<=totalNum){
                        search(foodlist,i,fd.getV()+curNum,totalNum);
                    }else {
                        search(foodlist,i+1,curNum,totalNum);
                    }
                }
            }
        }
    }
    static class Food{
        int id;
        int v;
        int like;

        public Food(int id, int v) {
            this.id = id;
            this.v = v;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }

        public int getLike() {
            return like;
        }

        public void setLike(int like) {
            this.like = like;
        }
    }
}
