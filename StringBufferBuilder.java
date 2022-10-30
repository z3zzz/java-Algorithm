import java.lang.StringBuilder;
import java.lang.StringBuffer;

/* String 은 immutable (concat 불가, concat 하려면 concat 하면서 새로 String 만들어야 함) 
 * StringBuffer, StringBuilder 은 mutable (concat 가능)
 *
 * */

public class StringBufferBuilder {
    static void startBuffer(int N) {
        StringBuffer sb = new StringBuffer();
        long t = System.currentTimeMillis();

        for (int i=0; i < N; i++) {
            sb.append("");
        }
        System.out.print("Buffer ");
        System.out.println(System.currentTimeMillis() - t);

    }

    static void startBuilder(int N) {
        StringBuilder sb = new StringBuilder();
        long t = System.currentTimeMillis();

        for (int i=0; i < N; i++) {
            sb.append("");
        }
        System.out.print("Builder ");
        System.out.println(System.currentTimeMillis() - t);

    }

    public static void main(String[] args) {
        int N = 999999999;

        startBuffer(N);
        startBuilder(N);
    }
  
}
