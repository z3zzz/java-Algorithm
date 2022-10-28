import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// 반 나누어 sort 하고 merge (하나하나 비교하며 새 array 제작) 하면 됨
// int i = ( m + n ) / 2 가능

public class MergeSort {
    static int[] merge(int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] result = new int[left.length + right.length];

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
        } 

        while (i < left.length) {
            result[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            result[k] = right[j];
            j++;
            k++;
        }

        return result;
    }

    static int[] sort(int[] arr, int low, int high) {
          if (low < high) {
              int m = (low + high) / 2;
              int[] left = sort(arr, low, m);
              int[] right = sort(arr, m+1, high);

              int[] result = merge(left, right);

              return result;
          }

          int[] single = new int[1];
          single[0] = arr[low];

          return single;
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

        int[] result = sort(target, 0, target.length-1);
        print(result);
    }
}
