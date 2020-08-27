import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        int n = numbers.length;
        if (n <= 1) {
        	return Long.MIN_VALUE;
        }
        else if (n == 2) {
        	if (numbers[0] != numbers[1]) {
        		return (long) numbers[0]*numbers[1];
        	}
        	else {
        		return Long.MIN_VALUE;
        	}
        }
        int i0 = 0;
        for (int i = 1; i < n; i++) {
        	if (numbers[i] > numbers[i0]) {
        		i0 = i;
        	}
        }
        // Swap numbers[i0] with numbers[n-1]
        int dummy0 = numbers[n-1];
        numbers[n-1] = numbers[i0];
        numbers[i0] = dummy0;
        
        i0 = 0;
        for (int i = 1; i < n-1; i++) {
        	if (numbers[i] > numbers[i0] && numbers[i] != numbers[n-1]) {
        		i0 = i;
        	}
      }
      // Swap numbers[i0] with numbers[n-2]
      int dummy1 = numbers[n-2];
      numbers[n-2] = numbers[i0];
      numbers[i0] = dummy1;
      return (long) numbers[n-1]*numbers[n-2];
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
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
