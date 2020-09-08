import java.util.*;
import java.io.*;

public class MaxSlidingWindow  {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public void solve() throws IOException {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) a[i] = scanner.nextInt();
        int window = scanner.nextInt();
        for (int l = 0; l + window <= n; ++l) {
           int curMax = a[l];
           for (int i = l + 1; i < l + window; ++i)
             if (curMax < a[i]) curMax = a[i];
           System.out.print(curMax);
           System.out.print(' ');
        }
        System.out.println();
    }

    static public void main(String[] args) throws IOException {
        new MaxSlidingWindow().solve();
    }
}