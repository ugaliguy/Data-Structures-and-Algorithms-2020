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
        int[] cnt = new int[points.length];
        int n = starts.length;
        int p = points.length;
        int i = 0;
        Pair[] pairs = new Pair[n*2 + p];
        HashMap<Integer,ArrayList<Integer>> pointsMap = new HashMap<Integer,ArrayList<Integer>>();
        
        System.out.println(Arrays.toString(starts));
        System.out.println(Arrays.toString(ends));
        //write your code here
        //Label each point as follows starts:1, ends:3 and points:2
        for(int start:starts)
            pairs[i] = new Pair(start,1);
        	System.out.print("start i = ");
        	System.out.print(i);
        	System.out.print(" start =  ");
        	System.out.println(pairs[i]);
        	i += 1;
        	
        for(int end:ends)
            pairs[i] = new Pair(end,3);
        	System.out.print("end i = ");
        	System.out.print(i);
        	System.out.print(" end =  ");
        	System.out.println(pairs[i]);
            i += 1;
            
        for(int j=0; j < p; j++) {
        	pairs[i]=new Pair(points[j],2);
        	i += 1;
        	if (pointsMap.containsKey(points[j])) {
        		pointsMap.get(points[j]).add(j);
        	}
        	else {
        		ArrayList<Integer> list= new ArrayList<>();
                list.add(j);
                pointsMap.put(points[j],list);
        	}
        }
        
        for (Pair pair: pairs) {
//        	System.out.print("FARTZ: ");
//        	System.out.println(pair.toString());
        	System.out.println(pair);
        }
        
        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.a==o2.a)
                    return Integer.compare(o1.b, o2.b);
                return Integer.compare(o1.a, o2.a);
            }
        });
        
        int coverage=0;
        for (Pair pair: pairs){
            if(pair.b==1) //If it's a starting point of any segment
                coverage++;
            else if(pair.b==3) //If it's a ending point of any segment
                coverage--;
            else { //if it's a point
                ArrayList<Integer> indexes=pointsMap.get(pair.a);
                for(Integer k:indexes){
                    cnt[k]=coverage;
                }
            }
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

