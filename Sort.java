import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.Arrays;

public class Sort {
    public static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void bubbleSort(Integer[] numsArray) {
        while (true) {
            boolean isDone = true;
            for (int i = 0; i < numsArray.length - 1; i++) {
                if (numsArray[i] > numsArray[i + 1]) {
                    swap(numsArray, i, i + 1);
                    isDone = false;
                }
            }
            System.out.println(Arrays.toString(numsArray));

            if (isDone) break;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        String[] numsStringArray = userInput.split(" ");
        // Double Colon 연산자 (class::method) 형태이며, lambda 함수의 shorthand이다. s -> class.method(s) 의 shorthand
        // 주로 stream의 map, foreach 등에 쓰인다
        Integer[] numsArray = Stream.of(numsStringArray).map(Integer::valueOf).toArray(Integer[]::new);
        System.out.println(Arrays.toString(numsArray));

        bubbleSort(numsArray);

    }
}
