import java.util.*;
import java.io.*;

/*
 * BFS (neerest first)
 * LinkedList[] adj 와 queue 로 구현 
 * vertice num 이 adj 의 index로 작용, value 는 adjecent node num 
 * boolean[] visited 역시 index로 vertice num 사용 
 * cycle 대응 가능
 *
 * */

public class GraphBFS {
    private int numberOfVertices;
    private LinkedList<Integer> adj[];

    GraphBFS(int v) {
        numberOfVertices = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }
    }

    void addNode(int v, int adjVertice) {
        adj[v].add(adjVertice);
    }

    void traverse(int startingVertice) {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[numberOfVertices];

        queue.add(startingVertice);
        visited[startingVertice] = true;

        while (queue.size() != 0) {
            int cur = queue.poll();
            System.out.print(cur + " -> ");

            Iterator iter = adj[cur].iterator();

            while (iter.hasNext()) {
                int adjVertice = (int) iter.next();

                if (!visited[adjVertice]) {
                    visited[adjVertice] = true;
                    queue.add(adjVertice);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphBFS graph = new GraphBFS(6);
        graph.addNode(0, 1);
        graph.addNode(0, 2);
        graph.addNode(1, 2);
        graph.addNode(2, 0);
        graph.addNode(2, 3);
        graph.addNode(3, 3);
        graph.addNode(3, 4);
        graph.addNode(3, 5);
        
        graph.traverse(2);
    }
}
