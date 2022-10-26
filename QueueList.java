import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class QueueList {
    // LinkedList로 Queue 생성 후 Iterator 사용
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        // using Iterator to iterate through a queue
        Iterator<Integer> itr = queue.iterator();

        // hasNext() returns true if the queue has more elements
        while (itr.hasNext()) {
            // next() returns the next element in the iteration
            System.out.println(itr.next());
        }
    }
}