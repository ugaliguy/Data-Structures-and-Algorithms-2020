import java.util.*;
import java.io.*;

public class CarFueling {
	
    static int computeMinRefills(int dist, int tank, int[] stops) {
    	int refills = 0;
    	int current = 0;
    	int last = 0;
    	int n =stops.length;
    	int[] x = new int[n+2];
    	x[0] = 0;
    	x[n+1] = dist;
    	for (int i = 0; i < n; i++) {
    		x[i+1] = stops[i];
    	}

    	while (current <= n) {

    		last = current;
    		 
    		while ((current <= n) && (x[current + 1] - x[last] <= tank)) {
    			current += 1;
    		}
    		if (current == last) {
    			return -1;
    		}
    		if (current <= n) {
    			refills += 1;
    		}
    	}
        return refills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
        scanner.close();
    }
}
