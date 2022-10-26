import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class StringMagic {
    // str -> arr로 바꾸고, length() 얻고, for loop로 뒤부터 출력
    static void reverseString(String str) {
        char[] strArray = str.toCharArray();
        int strLength = str.length();
        for (int i = 0; i < strLength; i++) {
            System.out.print(strArray[strLength - i - 1]);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();

        reverseString(userInput);
    }
}
