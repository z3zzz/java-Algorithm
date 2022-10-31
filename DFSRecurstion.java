import java.util.*;
import java.io.*;

/*
 * Node, Graph 등 class는 main Class와 별도로 정의
 * pre는 recursion도 pre, post도 마찬가지, in도 마찬가지
 * */

class Node {
    public String data;
    public Node left;
    public Node right;

    Node(String name) {
        data = name;
    }
    
    void addLeft(Node N) {
        left = N;
    }

    void addRight(Node N) {
        right = N;
    }
}

class Graph {
    public Node rootNode;

    Graph(Node N) {
        rootNode = N;
    }

    void dfsInorder(Node curNode) {
        if (curNode != null) {
            dfsInorder(curNode.left);
            System.out.print(curNode.data + " -> ");
            dfsInorder(curNode.right);
        }
    }

    void dfsPreorder(Node curNode) {
        if (curNode != null) {
            System.out.print(curNode.data + " -> ");
            dfsPreorder(curNode.left);
            dfsPreorder(curNode.right);
        }

    }
    void dfsPostorder(Node curNode) {
        if (curNode != null) {
            dfsPostorder(curNode.left);
            dfsPostorder(curNode.right);
            System.out.print(curNode.data + " -> ");
        }

    }
}
    
public class DFS {
    public static void main(String[] args) {
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("G");
        Node H = new Node("H");
        Node I = new Node("I");
        Node J = new Node("J");

        A.addLeft(B);
        A.addRight(C);
        B.addLeft(D);
        C.addLeft(E);
        E.addLeft(F);
        F.addLeft(G);
        F.addRight(H);
        H.addLeft(I);
        I.addLeft(J);

        Graph graph = new Graph(A);

        System.out.println("Inorder");
        graph.dfsInorder(graph.rootNode);
        System.out.println();

        System.out.println("Preorder");
        graph.dfsPreorder(graph.rootNode);
        System.out.println();

        System.out.println("Postorder");
        graph.dfsPostorder(graph.rootNode);
        
    }
}
