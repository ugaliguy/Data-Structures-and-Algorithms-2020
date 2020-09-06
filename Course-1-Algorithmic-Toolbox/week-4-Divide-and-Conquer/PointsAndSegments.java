import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;

public class PointsAndSegments {
	
	private static class Pair {
        int a, b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public String toString() { 
            return String.format("[" + this.a + "," + this.b + "]"); 
        }
    }

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
    	int s = starts.length;
    	int e = ends.length;
    	int p = points.length;
    	int[] cnt = new int[p];
        Arrays.sort(starts);
        Arrays.sort(ends);
        for (int i = 0; i < p; i++) {
            int si = 0, ei = 0;

            while (si < s && starts[si] <= points[i]) si++;

            while (ei < e && ends[ei] < points[i]) ei++;

            cnt[i] = si - ei;
        }
        return cnt;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
//            System.out.print("start = ");
//        	System.out.println(starts[i]);
            ends[i] = scanner.nextInt();
//            System.out.print("end = ");
//        	System.out.println(ends[i]);
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
        scanner.close();
    }
}

