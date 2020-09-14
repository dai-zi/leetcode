package com.csms.leetcode.number.n100.n120;

import com.csms.leetcode.common.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//克隆图
//中等
public class Leetcode133 {
    private HashMap<Node, Node> visited = new HashMap <> ();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        // If the node was already visited before.
        // Return the clone from the visited dictionary.
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a clone for the given node.
        // Note that we don't have cloned neighbors as of now, hence [].
        Node cloneNode = new Node(node.val, new ArrayList());
        // The key is original node and value being the clone node.
        visited.put(node, cloneNode);

        // Iterate through the neighbors to generate their clones
        // and prepare a list of cloned neighbors to be added to the cloned node.
        for (Node neighbor: node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }

    //save time
//    private Map<Node, Node> visited = new HashMap<>();
//    public Node cloneGraph(Node node) {
//        if(node == null)
//            return node;
//
//        if(visited.containsKey(node))
//            return visited.get(node);
//
//        Node copiedNode = new Node(node.val, new ArrayList<Node>());
//        visited.put(node, copiedNode);
//
//        for(Node neighbor : node.neighbors) {
//            copiedNode.neighbors.add(cloneGraph(neighbor));
//        }
//
//        return visited.get(node);
//    }

    public static void main(String[] args) {
    }
}