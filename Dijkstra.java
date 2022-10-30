import java.util.*;

/*
 * Dijkstra -> 최단거리
 * 가장 가까운 node로 나아가고, 해당 node에 인접한 node들까지 누적거리 계산하고, 다시 가장 가까운 node로 가기 반복
 * 모든 node 나아갔을 때 종료 -> 각 거리 출력
 *
 * int Integer 연산 호환 자유
 * Integer.MAX_VALUE
 * HashSet() -> add, remove, contains
 * HashMap() -> entrySet, Map.Entry<keyType, valueType>, getKey(), getValue(), key로 object 가능
 *
 * */

class Node {
    public String name;
    public Integer shortestDistance;
    public HashMap<Node, Integer> adjacentNodes;
    public List<Node> shortestPath;

    Node(String name) {
        this.name = name;
        shortestDistance = Integer.MAX_VALUE;
        adjacentNodes = new HashMap<Node, Integer>();
        shortestPath = new LinkedList<Node>();
    }

    void addAdjecentNode(Node N, Integer d) {
        adjacentNodes.put(N, d);
    }

    void setShortestDistance(Node N, int weight) {
        int distance = N.shortestDistance + weight;
        if (distance < this.shortestDistance) {
            this.shortestDistance = distance;
        } 
    }
}

class Graph {
    public HashMap<String ,Node> nodes;

    Graph(){
        nodes = new HashMap<String, Node>();
    }

    Node getNode(String name) {
        return nodes.get(name);
    }

    void addNode(Node N) {
        nodes.put(N.name, N);
    }

    Node getShortestDistanceNode(Set<Node> nodes) {
        Node resultNode = null;
        int lowestDistance = Integer.MAX_VALUE;

        for (Node node: nodes) {
            if (node.shortestDistance < lowestDistance) {
                lowestDistance = node.shortestDistance;
                resultNode = node;
            }
        }

        return resultNode;
    }

    void setShortestDistanceFrom(String name) {
        Node startNode = this.getNode(name);
        startNode.shortestDistance = 0;

        Set<Node> visitedNodes = new HashSet<>();
        Set<Node> unVisitedNodes = new HashSet<>();

        unVisitedNodes.add(startNode);

        while (unVisitedNodes.size() != 0) {
            Node sourceNode = getShortestDistanceNode(unVisitedNodes);
            unVisitedNodes.remove(sourceNode);

            for (Map.Entry<Node, Integer> e: sourceNode.adjacentNodes.entrySet()) {
                if (!visitedNodes.contains(e.getKey())) {
                    Node candidateNode = e.getKey();
                    int weight = e.getValue();
                    candidateNode.setShortestDistance(sourceNode, weight);
                    unVisitedNodes.add(candidateNode);
                }
            }

            visitedNodes.add(sourceNode);
        }
    }

    void getShortestDistances() {
        for (Map.Entry<String, Node> e: nodes.entrySet()) {
            String nodeName = e.getKey();
            Node node = e.getValue();
            System.out.printf("Shortest Distance for %s: %s", nodeName, node.shortestDistance).println();
        }
    }
}

public class Dijkstra {
    static Graph generateGraph(Node[] nodes) {
        Graph graph = new Graph();

        for (int i = 0; i < nodes.length; i++) {
            graph.addNode(nodes[i]);
        }

        return graph;
    }
    
    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");

        nodeA.addAdjecentNode(nodeB, 10);
        nodeA.addAdjecentNode(nodeC, 6);
        nodeA.addAdjecentNode(nodeE, 9);

        nodeB.addAdjecentNode(nodeC, 3);
        nodeB.addAdjecentNode(nodeD, 7);

        nodeC.addAdjecentNode(nodeD, 4);
        nodeC.addAdjecentNode(nodeE, 6);

        nodeD.addAdjecentNode(nodeE, 2);

        Node[] nodes = {nodeA, nodeB, nodeC, nodeD, nodeE};

        Graph graph = generateGraph(nodes);
        graph.setShortestDistanceFrom("A");
        graph.getShortestDistances();
    }
}
