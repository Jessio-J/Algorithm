package datastruct;

import java.util.List;

public class GNode {
    public int val;
    public List<GNode> neighbors;

    public GNode() {

    }

    public GNode(int _val,List<GNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
