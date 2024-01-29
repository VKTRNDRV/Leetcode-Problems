package medium.cloneGraph;

import utils.graphNode.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private Map<Integer, Node> nodesClones = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) return null;

        if(!nodesClones.containsKey(node.val)){
            nodesClones.put(node.val, new Node(node.val));
        }

        Node clone = nodesClones.get(node.val);
        List<Node> neighborsClones = new ArrayList<>();

        for(Node neighbor : node.neighbors){
            if(nodesClones.containsKey(neighbor.val)){
                neighborsClones.add(nodesClones.get(neighbor.val));
                continue;
            }

            neighborsClones.add(cloneGraph(neighbor));
        }

        clone.neighbors = neighborsClones;

        return clone;
    }
}
