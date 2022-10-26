import java.util.Scanner;

class LinkedList {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int n) {
            data = n;
            next = null;
        }
    }

    public void push(int d) {
        Node newNode = new Node(d);

        if (head == null) {
            head = newNode;
        } else {
            Node curNode = head;
            while (curNode.next != null) {
                curNode = curNode.next;
            }

            curNode.next = newNode;
        }
    }

    public void print() {
        if (head == null) {
            System.out.println("No node to show");
        } else {
            Node curNode = head;
            while (curNode.next != null) {
                System.out.print(curNode.data + " -> ");
                curNode = curNode.next;
            }

            System.out.println(curNode.data);
        }
    }

    public Node find(int d) {
        System.out.println("Looking for " + d);
        Node curNode = head;
        while (curNode.next != null) {
            if (curNode.data == d) return curNode;
            curNode = curNode.next;
        }
        if (curNode.data == d) return curNode;

        System.out.println("Number " + d + " not found");

        return null;
    }

    public void insertAfter(int target, int newNumber) {
        Node newNode = new Node(newNumber);
        boolean isInserted = false;

        Node targetNode = find(target);

        if (targetNode != null) {
            Node nextNode = targetNode.next;
            targetNode.next = newNode;
            newNode.next = nextNode;
        }
    }
}

public class LinkedListNode {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList listl = new LinkedList();
        for (int i = 0; i < 5; i ++) {
            int n = sc.nextInt();
            listl.push(n);
        }

        listl.print();

        int new1 = sc.nextInt();
        listl.insertAfter(new1, 999);
        listl.insertAfter(15, 33);
        listl.print();
    }
}
