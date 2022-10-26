import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class LinkedListGenerate {
    static LinkedList<Integer> generateRandomLinkedList(int n) {
        int[] nums = new int[n];

        for (int i=0;i<n;i++) {
            nums[i] = (int) Math.round(Math.random() * 100);
        }

        Arrays.sort(nums);

        LinkedList<Integer> numsList = new LinkedList<Integer>();

        for (int num: nums) {
            numsList.addLast(num);
        }

        System.out.println(numsList);

        return numsList;
    }
    static void insertToLinkedList(LinkedList<Integer> numsList, Integer n) {
        LinkedList<Integer> newList = new LinkedList<Integer>();
        boolean isInserted = false;

        for (int i = 0; i < numsList.size() - 1; i++) {
            if (n >= numsList.get(i) && n < numsList.get(i+1)) {
                newList.addLast(numsList.get(i));
                newList.addLast(n);
                isInserted = true;
            } else {
                newList.addLast(numsList.get(i));
            }
        }

        if (!isInserted) {
            if (n < numsList.get(0)) {
                newList.addFirst(n);
            } else if (numsList.get(numsList.size() - 1) <= n) {
                newList.addLast(numsList.get(numsList.size() - 1));
                newList.addLast(n);
            } else {
                newList.addLast(n);
                newList.addLast(numsList.get(numsList.size() - 1));

            }
        }

        System.out.println(newList);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();
        LinkedList<Integer> numsList = generateRandomLinkedList(userInput);

        int userInput2 = sc.nextInt();
        insertToLinkedList(numsList, userInput2);
    }
}
