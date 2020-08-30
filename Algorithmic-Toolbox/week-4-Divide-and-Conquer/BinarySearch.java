import java.io.*;
import java.util.*;

public class BinarySearch {

    static int binarySearch(int[] a, int low, int high, int x) {
//        int left = 0;
//        int right = a.length - 1;
//        	
        //write your code here
        if (high < low) {
        	return -1;
//        	return low - 1 // Returns the index after which you could insert the element if it's not in the array
        }
        int mid =  (low + high)/2;
//        if (x == a[mid]) {
//        	return mid;
//        }
//        else if (x < a[mid]) {
//        	return binarySearch(a, low, mid - 1, x);
//        }
//        else {
//        	return binarySearch(a, mid + 1, high, x);
//        }
//        return -1;
        while (low <= high) {
//            int mid = low + (high - low) / 2;
            if (a[mid] == x) {
                return mid;
            } else if (x > a[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return -1;
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            System.out.print(binarySearch(a, 0, n-1, b[i]) + " ");
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
