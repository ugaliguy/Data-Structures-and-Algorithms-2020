import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
    	int n = values.length;
    	double[][] ratios = new double[n][2];
    	for (int i = 0; i < n; i++) {
    		ratios[i][0] = values[i];
    		ratios[i][1] = weights[i];
    	}
    	Comparator<double[]> c = (X, Y) -> X[0] / X[1] < Y[0] / Y[1] ? 1 : -1;
    	Arrays.sort(ratios, c);
        double value = 0;
        int j = 0;
        while (capacity > 0 && j < n) {
        	double a = Math.min(ratios[0][1], capacity);
        	value += a*ratios[j][0]/ratios[j][1];
        	capacity -= a;
        	j += 1;
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
