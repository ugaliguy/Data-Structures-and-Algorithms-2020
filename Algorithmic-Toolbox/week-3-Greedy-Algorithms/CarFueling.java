import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
    	int refills = 0;
    	int current = 0;
    	int last = 0;
    	
    	while (current < (dist - 1)) {
    		last = current;
    		System.out.println(current + 1);
    		while ((current < stops.length - 1) && (stops[current + 1] - stops[last] <= tank)) {
    			current += 1;
    			if (current == dist - 1) {
    				break;
    			}
    		}
    		if (current == last) {
    			return -1;
    		}
    		if (current < last - 1) {
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
