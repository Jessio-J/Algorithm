package P101TO150.P133;

import datastruct.GNode;
import datastruct.graph.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//dfs
public class P133 {
    public Node cloneGraph(Node node) {
        Map<Integer,Node> map = new HashMap();
        Node n = new Node(node.val, null);
        map.put(node.val,n);
        n.neighbors = copy(node, map);
        return n;
    }
    private List<Node> copy(Node node, Map<Integer,Node> map){
        List<Node> list = new ArrayList<>();
        for(Node n : node.neighbors){
            if(map.containsKey(n.val)){//判断该节点是否已经创建了
                list.add(map.get(n.val));
            }else{
                Node nn = new Node(n.val, null);//节点未创建，创建并拷贝 neighbors
                list.add(nn);
                map.put(n.val, nn);
                nn.neighbors = copy(n, map);
            }
        }
        return list;
    }
}
