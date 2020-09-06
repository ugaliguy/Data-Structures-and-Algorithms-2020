import java.util.*;

public class CoveringSegments {

    private static ArrayList<Integer> optimalPoints(Segment[] segments) {
        //write your code here

    	Comparator<Segment> a = (X, Y) -> X.end > Y.end ? 1 : -1;
        Arrays.sort(segments, a);

        ArrayList<Integer> points = new ArrayList<>();
        int point = segments[0].end;
        points.add(point);
        for (int i = 1; i < segments.length; i++) {
            if (point < segments[i].start) {
                point = segments[i].end;
                points.add(point);
            }
        }

        return points;
    }

    private static class Segment {
    	int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
        
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        ArrayList<Integer> points = optimalPoints(segments);
        System.out.println(points.size());
        for (int point : points) {
            System.out.print(point + " ");
        }
        
        scanner.close();
    }
}
 
