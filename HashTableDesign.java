import java.util.HashMap;
import java.util.Map;

/* put, get, remove
 * containsKey(key)
 * size(), entrySet(), Entry<keyType, valueType>
 * Map.Entry<keyType, valueType> e: map.entrySet() -> e.getKey(), e.getValue();
 * */

public class HashTableDesign {
    
    public static void main(String[] args) {
        HashMap<String, String> h1 = new HashMap<>();
        
        h1.put("a", "apple");
        h1.put("b", "apple");
        h1.put("c", "apple");

        h1.put("d", "banna");

        if (h1.containsKey("d"))
            System.out.println("if works,");
        else
            System.out.println("if no works,");

        // iter
        for (Map.Entry<String, String> e: h1.entrySet()) {
            System.out.printf("key is %s, value is %s", e.getKey(), e.getValue());
        }
            

        System.out.println(h1);
        System.out.println(h1.size());
    }
}
