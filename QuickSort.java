import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// Partition을 계속 반복하면 sort 완료 

public class QuickSort {
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high) {
          int i = low - 1;
          int pivot = arr[high];
          for (int j = low; j <= high; j++) {
              if (arr[j] < pivot) {
                  i++;
                  swap(arr, i, j);
              }
  
          }
          swap(arr, i+1, high);

          return i+1;
    }

    static void quickSort(int[] arr, int low, int high) {
          if (low < high) {
              int part = partition(arr, low, high);

              quickSort(arr, low, part-1);
              quickSort(arr, part+1, high);
          }
    }

    static void print(int[] arr) {
          for (int i = 0; i < arr.length; i++) {
              System.out.print(arr[i] + " ");
          }
    }
    
    public static void main(String[] args) {
        int[] target = {3, 9, 10, 401, 30, 65, 99, 20, 103, 405, 99, 2};
        print(target);
        System.out.println();
        quickSort(target, 0, target.length - 1);
        print(target);
    }
}
