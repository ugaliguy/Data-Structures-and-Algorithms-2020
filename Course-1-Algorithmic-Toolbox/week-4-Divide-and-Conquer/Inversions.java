import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left) {
            return numberOfInversions;
        }
        int avg = (left + right) / 2;
//        numberOfInversions += getNumberOfInversions(a, b, left, ave);
//        numberOfInversions += getNumberOfInversions(a, b, ave, right);
        //write your code here
        numberOfInversions = getNumberOfInversions(a, b, left, avg);
		numberOfInversions += getNumberOfInversions(a, b, avg + 1, right);
		numberOfInversions += merge(a, b, left, avg + 1, right);
        return numberOfInversions;
    }
    
    private static long merge(int[] a, int b[], int left, int avg, int right) {
        int i = left, j = avg, k = left;
        long count = 0;
        while (i <= (avg - 1) && j <= right) {
            if (a[i] <= a[j]) {
                b[k] = a[i];
				i++;
				k++;
            } else {
                b[k] = a[j];
				count += (avg - i);
				j++;
				k++;
            }
        }
        while (i <= (avg - 1)) {
            b[k] = a[i];
            i++;
            k++;
        }
        while (j <= right) {
            b[k] = a[j];
            j++;
            k++;
        }	
		for (i=left; i <= right; i++)
			a[i] = b[i];
		
		return count;
    }
      

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length - 1));
        scanner.close();
    }
}

