import java.util.*;
import java.io.*;

public class MaxSlidingWindow  {
	
	public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        int counter = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>(); //notice that, this is not programmed to interface
        
        for(int i=0; i < k; i++) {
            //skip # 1 step 
            
             while(!q.isEmpty() && nums[i] >= nums[q.getLast()]) {
                 q.removeLast();
             }
            
            q.add(i);
        }
        
        result[counter++] = nums[q.peek()];
        
        for(int i=k; i < n; i++) {
            if(!q.isEmpty() && q.peek() < (i-k+1)) {
                q.remove();
            }
            
             while(!q.isEmpty() && nums[i] >= nums[q.getLast()]) {
                 q.removeLast();
             }
            
            q.add(i);
            
            result[counter++] = nums[q.peek()];
        }
        
        return result;
    }

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