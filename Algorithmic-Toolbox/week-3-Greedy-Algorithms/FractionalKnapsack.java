import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
//    	int n = values.length;
//    	double[][] ratios = new double[n][3];
//    	for (int i = 0; i < n; i++) {
//    		ratios[i][0] = values[i];
//    		ratios[i][1] = weights[i];
//    		ratios[i][2] = 1.0*values[i]/weights[i];
//    	}
////    	System.out.println(ratios.length);
////    	Comparator<double[]> c = (X, Y) -> X[0] / X[1] < Y[0] / Y[1] ? 1 : -1;
//    	Comparator<double[]> c = (X, Y) -> X[2] > Y[2] ? 1 : -1;
//    	Arrays.sort(ratios, c);
//        double result = 0;
//        int j = 0;
////        while (capacity > 0 && j < n) {
////        	double a = Math.min(ratios[0][1], capacity);
////        	result += a*ratios[j][0]/ratios[j][1];
////        	capacity -= a;
////        	j += 1;
////        }
////        return result;
////        int index= ratios.length-1;
//        while(capacity > 0 && j < n){
//            double[] item = ratios[n-1];
//            if (capacity >= item[1]){
//                capacity-=item[1];
//                result += item[0];
//            }else{
//
//                result += capacity*item[2];
//                capacity = 0;
//            }
//            j += 1;
//        }
//
//        return (double)Math.round(result*10000d)/10000d;
    	double value = 0;
        //we sort the items by its value per unit
        double items[][]=new double[values.length][3];
        for (int i=0; i<values.length; i++){
            items[i][0]=(double)values[i]/weights[i];
            items[i][1]=(double)values[i];
            items[i][2]=(double)weights[i];
        }

        Arrays.sort(items, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return Double.compare(o1[0], o2[0]);
            }
        });



        int index=items.length-1;
        while(capacity>0 && index>=0){
            double[] item=items[index];
            if (capacity>=item[2]){
                capacity-=item[2];
                value+=item[1];
            }else{

                value+= capacity*item[0];
                capacity=0;
            }
            index--;
        }

        return (double)Math.round(value * 10000d) / 10000d;
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
