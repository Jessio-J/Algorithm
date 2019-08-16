package exam.huawei.D20180814;

import java.util.*;

public class class3 {
    static class Friend{
        int id;
        List<FriendShip> friends = new ArrayList<>();

        public Friend(int id) {
            this.id = id;
        }
    }
    static class FriendShip{
        int i;
        int j;
        int w;

        public FriendShip(int i, int j, int w) {
            this.i = i;
            this.j = j;
            this.w = w;
        }
    }
    static class FriendShipN{
        int j;
        int value;

        public FriendShipN(int j, int value) {
            this.j = j;
            this.value = value;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 0; i < test; i++) {
            int m = sc.nextInt();
            int index = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();
            Friend[] farr = new Friend[m];
            for(int a= 0;a<m;a++){
                farr[a] = new Friend(a);
            }
            for (int j = 0; j < k; j++) {
                int tmpi = sc.nextInt();
                int tmpj = sc.nextInt();
                int w = sc.nextInt();
                farr[tmpi].friends.add(new FriendShip(tmpi,tmpj,w));
                farr[tmpj].friends.add(new FriendShip(tmpj,tmpi,w));
            }

            Friend indexFriend = farr[index];
            Set<Integer> set = new HashSet<>();
            set.add(indexFriend.id);
            find(farr,indexFriend,set,n,0,0);
            for (FriendShipN re : res) {
                System.out.println(re.j);
            }
        }
    }

    static PriorityQueue<FriendShipN>  res = new PriorityQueue<>(new Comparator<FriendShipN>() {
        @Override
        public int compare(FriendShipN o1, FriendShipN o2) {
            return o2.value-o1.value;
        }
    });
    public static void find(Friend[] farr,Friend f,Set<Integer> set,int targetN, int curn,int curValue) {
        if(curn==targetN){
            res.add(new FriendShipN(f.id,curValue));
        }else {
            for (FriendShip friend : f.friends) {
                if(!set.contains(friend.j)){
                    set.add(friend.j);
                    find(farr,farr[friend.j],set,targetN,curn+1,curValue+friend.w);
                    set.remove(friend.j);
                }
            }
        }

    }
}
