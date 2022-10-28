//import java.util.*;  이렇게 하면 LinkedList에 대한 컴파일 에러 발생
import java.util.LinkedList;
import java.util.Iterator;

/*
 * new LinkedList<타입>() 로 생성
 * object[] -> {a, b}  / [0] = a, [1] = b
 */

// LinkedList의 array로 구현된 hashmap
// array의 인덱싱은 key의 hashcode의 %size 값, bucket sort와 유사, 2차 linkedlist가 존재
class HashMap {
    private int size; // 실제 크기 (load factor 0.75)
    private int initialSize; // 사용자가 입력한 크기
    private int hashMapItemCount;
    private LinkedList<Object[]>[] map;

    public HashMap(){}

    @SuppressWarnings("unchecked")
    public HashMap(int size) {
        initialSize = size;
        this.size = size * 4/3;
        hashMapItemCount = 0;
        map = new LinkedList[this.size];
    }

    public float getLoad() {
        return (float) hashMapItemCount / size;
    }

    public String set(String key, Object value) {
        if (hashMapItemCount >= initialSize) return "Hashmap is full!";
  
        // Math.abs 안 하면 hashCode는 음수 가능
        int bucket = Math.abs(key.hashCode() % size);
        
        if (map[bucket] == null) {
            LinkedList<Object[]> valueList = new LinkedList<Object[]>();
            Object[] keyValuePair = {key, value};
            valueList.add(keyValuePair);
            map[bucket] = valueList;
        } else {
            LinkedList<Object[]> valueList = map[bucket];
            Object[] keyValuePair = {key, value};

            Iterator iter = valueList.iterator();

            while (iter.hasNext()) {
                Object[] cur = (Object[]) iter.next();
                if (cur[0] == key) {
                    iter.remove();
                    hashMapItemCount--;
                    break;
                }
            }

            valueList.addLast(keyValuePair);
        }

        hashMapItemCount++;
        return "Set complete!";
    }


    public Object get(String key) {
        int bucket = Math.abs(key.hashCode() % size);
        LinkedList valueList = map[bucket];

        if (valueList == null) return null;

        Iterator iter = valueList.iterator();

        while (iter.hasNext()) {
            Object[] cur = (Object[]) iter.next();

            if (cur[0] == key) return cur[1];
        }
        
        return null;
    }

    public String delete(String key) {
        int bucket = Math.abs(key.hashCode() % size);
        LinkedList valueList = map[bucket];

        if (valueList == null) return "No value for the key: " + key;

        Iterator iter = valueList.iterator();

        while (iter.hasNext()) {
            Object[] cur = (Object[]) iter.next();

            if (cur[0] == key) {
                iter.remove();
                hashMapItemCount--;
                return "Delete comlete";
            }

        }

        return "No value for the key: " + key;
    }
}

public class HashMapDesign {
    public static void main(String[] args) {
        HashMap h1 = new HashMap(5);

        //삽입
        System.out.println(h1.getLoad());
        System.out.println(h1.set("Yellow", "Banana"));
        System.out.println(h1.getLoad());
        System.out.println("Yellow get - > " + h1.get("Yellow"));
        System.out.println("Yellow delete - > " + h1.delete("Yellow"));
        System.out.println(h1.getLoad());
        
        // 오버플로우
        System.out.println(h1.set("Red", "Apple"));
        System.out.println(h1.set("Purple", "Grape"));
        System.out.println(h1.set("Blue", "Berry"));
        System.out.println(h1.set("mango", "love"));
        System.out.println(h1.set("large", "pack"));
        System.out.println(h1.getLoad());
        
        // 기존 key 재사용
        System.out.println(h1.set("Red", "Tomato"));
        System.out.println("Red - > " + h1.get("Red"));
        
        // 삭제 - 성공
        System.out.println(h1.delete("Red"));
        System.out.println(h1.getLoad());
        
        // 삭제 - 실패
        System.out.println(h1.delete("Red"));
        
        // get - 실패
        System.out.println("Red -> " + h1.get("Red"));
    }


}
