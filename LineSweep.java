import java.util.Arrays;
import java.util.Comparator;

/*
 * 점들의 집합이 주어졌을 때 최소 거리 
 * 반으로 나눈 후 각각 최소 거리 구하고,
 * 각 최소 거리 중 작은 값을 d로 한 후,
 * x값이 중간 반에서 d 이내인 점들만 모아 strip 으로 모으고,
 * y값 기준 정렬한 후 for loop 2번 실행
 * packing bound 법칙에 의해 for loop 2번이어도 2번째 loop는 최대 6번까지만 실행, 따라서 O(n)
 * 점들 간 최소 거리가 d이므로, 그보다 작은 pack 이내에 점이 있을 수 없음. 이 조건 상 가능한 인접점들은 최대 6개임
 *
 * */

public class LineSweep {
   static class Point {
        public int x;
        public int y;

        Point(int x, int y ) {
            this.x = x;
            this.y = y;
        }

    }

    public static float calculateDistance(Point A, Point B) {
        return (float) Math.sqrt(Math.pow(A.x - B.x, 2) + Math.pow(A.y - B.y, 2));
    }

    // O(n^2) 방법
    public static float getMinimumDistanceByBrutalForce(Point[] points, int startIndex, int endIndex) {
        float min = Float.MAX_VALUE;

        for (int i=startIndex; i <= endIndex; i++) {
            for (int j=i+1; j <= endIndex; j++ ) {
                float distance = calculateDistance(points[i], points[j]);
                if (distance < min) 
                    min = distance;
            }
        }
        return min;
    }

    static class yComparator implements Comparator<Point> {
        @Override
        public int compare(Point A, Point B) {
            return Integer.compare(A.y, B.y);
        }
    }

    static void print(Point[] points) {
        for (int i = 0; i < points.length; i++) {
            Point point = points[i];
            System.out.printf("(%s, %s) ", point.x, point.y);
        }
    } 

    public static float getMinimumDistanceInStrip(Point[] strip, float d) {
        int size = strip.length;
        float min = d;
        print(strip);
        Arrays.sort(strip, 0, size, new yComparator());

        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size && (strip[j].y - strip[i].y) < d; j++) {
                float distance = calculateDistance(strip[i], strip[j]);
                min = Math.min(distance, min);
            }
        }
        return min;
    }

    // O(n * (logn)^2) 방법
    public static float getMinimumDistanceByLineSweep(Point[] points, int startIndex, int endIndex) {
        if (endIndex - startIndex <= 3) return getMinimumDistanceByBrutalForce(points, startIndex, endIndex);

        int middleIndex = (startIndex + endIndex) / 2;

        float d1 = getMinimumDistanceByLineSweep(points, startIndex, middleIndex);
        float d2 = getMinimumDistanceByLineSweep(points, middleIndex, endIndex);

        float d = Math.min(d1, d2);

        // 중간 middleIndex 로부터 x 거리가 d 이내인 점들만 찾아서 array에 넣음
        // 몇개나 있을지 모르므로 일단 최대 크기로 array 생성
        Point[] strip = new Point[endIndex - startIndex];
        int j = 0;

        for (int i = startIndex; i <= endIndex; i++ ) {
            if (Math.abs(points[i].x - points[middleIndex].x) < d) {
                strip[j] = points[i];
                j++;
            }
        }

        if (j <= 1) return d;

        return getMinimumDistanceInStrip(strip, d);
    }
    
    public static void main(String[] args) {
        Point[] points = new Point[]{
            new Point(2, 3),
            new Point(12, 30),
            new Point(40, 50),
            new Point(5, 1),
            new Point(12, 10),
            new Point(3, 4)
        };

        float min = getMinimumDistanceByLineSweep(points, 0, points.length - 1);
        System.out.println(min);
    }
}
