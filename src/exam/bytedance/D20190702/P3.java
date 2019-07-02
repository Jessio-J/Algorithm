package exam.bytedance.D20190702;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class P3 {
    static class TreeNode {
        public int val;
        public int max;
        public Map<TreeNode, Integer> nodeMap;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, TreeNode> map = new HashMap<>();
        int n = in.nextInt();
        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            TreeNode nodeu = null;
            TreeNode nodev = null;
            if (map.containsKey(String.valueOf(u))) {
                nodeu = map.get(String.valueOf(u));

            } else {
                nodeu = new TreeNode(u);
                nodeu.nodeMap = new HashMap<>();
                map.put(String.valueOf(u), nodeu);

            }
            if (map.containsKey(String.valueOf(v))) {
                nodev = map.get(String.valueOf(v));

            } else {
                nodev = new TreeNode(v);
                nodev.nodeMap = new HashMap<>();
                map.put(String.valueOf(v), nodev);
            }
            nodeu.nodeMap.put(nodev, w);
        }
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int x = in.nextInt();
            TreeNode itree = map.get(String.valueOf(x));
            if (itree.max > 0) {
                System.out.println(itree.max);
            } else {
                max = 0;
                getMax(itree, 0);
                itree.max = max;
                System.out.println(itree.max);
            }

        }
    }

    static int max = 0;

    public static void getMax(TreeNode t, int cursum) {
        if (t.nodeMap.size() == 0) {
            if (cursum > max) {
                max = cursum;
            }
        } else if(t.nodeMap.size() > 0){
            for (TreeNode node : t.nodeMap.keySet()) {
                int w = t.nodeMap.get(node);
                getMax(node, cursum + w);
            }
        }

    }
}
