import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Closest {

    static class Point implements Comparable<Point> {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return o.y == y ? Long.signum(x - o.x) : Long.signum(y - o.y);
        }
    }
    
    static double distance(Point a, Point b) {
    	long dX = a.x - b.x;
    	long dY = a.y - b.y;
    	return Math.sqrt(dX*dX + dY*dY);
    }
    
    static double distance(long x1, long y1, long x2, long y2) {
        long dX = x1 - x2;
        long dY = y1 - y2;
    	return Math.sqrt(dX*dX + dY*dY);
    }
    
    static double minimalDistance(Point[] points, int lo, int hi) {
    	if (hi <= lo)
    		return Double.POSITIVE_INFINITY;

    	if ((hi - lo) < 2)
    		return distance(points[lo], points[hi]);

    	int mid = lo + (hi - lo) / 2;

    	double d1 = minimalDistance(points, lo, mid);
    	double d2 = minimalDistance(points, mid + 1, hi);
    	double min = Math.min(d1, d2);

    	List<Point> strips = new ArrayList<Point>();
    	for (int i = lo; i <= hi; i++) {
    		if (Math.abs(points[mid].x - points[i].x) <= min) 
    			strips.add(points[i]);
    	}
    	return Math.min(min, stripClosest(strips, min));
    }

    static double stripClosest(List<Point> strips, double min) {
    	// sort points according to their y-coordinate
    	Collections.sort(strips);
    	for (int i = 0; i < strips.size(); i++) {
    		for (int j = i + 1; j < strips.size() && (strips.get(j).y - strips.get(i).y) <= min; j++) {
    			double dist = distance(strips.get(i), strips.get(j));
    			if (dist < min)
    				min = dist;
    		}
    	}
    	return min;
    }
    
    static double minimalDistance(int[] x, int y[]) {
        double ans = Double.POSITIVE_INFINITY;
        //write your code here
        int n = x.length;
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
        	points[i] = new Point(x[i], y[i]);
        }

        // sort points according to their x-coordinate
        Arrays.sort(points, new Comparator<Point>() {
        	public int compare(Point it, Point that) {
        		return it.x == that.x ?
            		Long.signum(it.y - that.y) : Long.signum(it.x - that.x);
        	}
        });

        ans = minimalDistance(points, 0, n - 1);
        return ans;
    }
    
    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
        }
        System.out.println(minimalDistance(x, y));
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
