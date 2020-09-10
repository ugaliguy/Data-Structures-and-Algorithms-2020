import java.util.*;
import java.io.*;

public class MaxSlidingWindow  {
	
	public class Solution {
	    public int[] maxSlidingWindow(int[] nums, int k) {
	        int n = nums.length;
	        if (n == 0 || n == 1 || k == 1) {
	            return nums;
	        }
	        int[] result = new int[n - k + 1];
	        // Store index
	        LinkedList<Integer> dq = new LinkedList<>();
	        for (int i = 0; i < n; i++) {
	            // remove index out of sliding window [i - k + 1, i]
	            if (!dq.isEmpty() && dq.peek() < i - k + 1) {
	                dq.poll();
	            }
	            // remove numbers in deque which are smaller than the new element nums[i] in the sliding window
	            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
	                dq.pollLast();
	            }
	            dq.offer(i);
	            if (i - k + 1 >= 0) {
	                result[i - k + 1] = nums[dq.peek()];
	            }
	        }
	        return result;
	    }
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