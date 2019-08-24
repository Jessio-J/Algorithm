package exam.jd.D20190824;

import java.util.*;

public class class2 {
    static class Person {
        int id;
        List<Integer> friends = new ArrayList<>();

        public Person(int id) {
            this.id = id;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Person[] a = new Person[2 * n];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Person(i + 1);
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            a[x - 1].friends.add(y);
            a[y - 1].friends.add(x);
        }
        Arrays.sort(a, (o1, o2) -> {
            if (o1.friends.size() < o2.friends.size()) return 1;
            if (o1.friends.size() > o2.friends.size()) return -1;
            if (o1.id < o2.id) return -1;
            if (o1.id > o2.id) return 1;
            return 0;
        });
        List<Integer> ids = new ArrayList<>();
        while (!check(a) ) {
            for (int id : a[0].friends) {
                for (int j = 0; j < a.length; j++) {
                    if(a[j].id ==id){
                        List<Integer> tmp  = new ArrayList<>();
                        for (Integer friend : a[j].friends) {
                            if(!friend.equals(id)){
                                tmp.add(friend);
                            }
                        }
                        a[j].friends = tmp;
                    }
                }
            }
            a[0].friends = new ArrayList<>();
            ids.add(a[0].id);
            Arrays.sort(a, (o1, o2) -> {
                if (o1.friends.size() < o2.friends.size()) return 1;
                if (o1.friends.size() > o2.friends.size()) return -1;
                if (o1.id < o2.id) return -1;
                if (o1.id > o2.id) return 1;
                return 0;
            });
        }
        System.out.println(ids.size());
        Collections.sort(ids);
        for (int j = 0; j < ids.size(); j++) {
            System.out.println(ids.get(j));

        }

    }

    public static boolean check(Person[] a) {

        for (int i = 0; i < a.length; i++) {
            if(a[i].friends.size()!=0){
                return false;
            }

        }
        return true;
    }
}

