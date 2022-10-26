import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class NumbersMagic {
    public static int absolute(int x) {
        if (x > 0) return x;
        return -x;
    }

    public static boolean isPrime(int x) {
        System.out.println("max: " + Math.round(Math.sqrt(x)));
        for (int i = 2; i < Math.round(Math.sqrt(x)); i++ ) {
            if (x % i == 0) return false;
        }
        return true;
    }

    public static double getHypoten(double a, double b) {
        return Math.sqrt(a*a + b*b);
    }

    public static long getRandom() {
        System.out.println(Math.random()* 100) ;
        return Math.round(Math.random() * 1000);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(absolute((x)));
        System.out.println(isPrime((x)));
        System.out.println(getHypoten(8, 15));
        System.out.println(getRandom());
    }

}
