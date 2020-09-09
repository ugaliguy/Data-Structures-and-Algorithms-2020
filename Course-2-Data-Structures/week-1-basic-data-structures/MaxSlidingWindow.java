import java.util.*;
import java.io.*;

public class MaxSlidingWindow  {
	
//	public int[] maxSlidingWindow(int[] nums, int k) {
//        int n = nums.length;
//        int[] result = new int[n-k+1];
//        int counter = 0;
//        ArrayDeque<Integer> q = new ArrayDeque<>(); //notice that, this is not programmed to interface
//        
//        for(int i=0; i < k; i++) {
//            //skip # 1 step 
//            
//             while(!q.isEmpty() && nums[i] >= nums[q.getLast()]) {
//                 q.removeLast();
//             }
//            
//            q.add(i);
//        }
//        
//        result[counter++] = nums[q.peek()];
//        
//        for(int i=k; i < n; i++) {
//            if(!q.isEmpty() && q.peek() < (i-k+1)) {
//                q.remove();
//            }
//            
//             while(!q.isEmpty() && nums[i] >= nums[q.getLast()]) {
//                 q.removeLast();
//             }
//            
//            q.add(i);
//            
//            result[counter++] = nums[q.peek()];
//        }
//        
//        return result;
//    }
	
//	public int[] maxSlidingWindow(int[] nums, int k) {
//	    if(nums==null||nums.length==0)
//	        return new int[0];
//	 
//	    int[] result = new int[nums.length-k+1];
//	 
//	    LinkedList<Integer> deque = new LinkedList<Integer>();
//	    for(int i=0; i<nums.length; i++){
//	        if(!deque.isEmpty()&&deque.peekFirst()==i-k) 
//	            deque.poll();
//	 
//	        while(!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]){
//	            deque.removeLast();
//	        }    
//	 
//	        deque.offer(i);
//	 
//	        if(i+1>=k)
//	            result[i+1-k]=nums[deque.peek()];
//	    }
//	 
//	    return result;
//	}
	
//	private static int[] maxSlidingWindow(int[] nums, int k) {
//        int ans[] = new int[nums.length - k + 1];
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        // Store the first k elements and their frequencies in a self balancing BST
//        for (int i = 0; i < k; i++) {
//            if (map.containsKey(nums[i])) {
//                map.put(nums[i], map.get(nums[i]) + 1);
//            } else {
//                map.put(nums[i], 1);
//            }
//        }
//        // Largest value of BST gives the first maximum
//        ans[0] = map.lastKey();
//        int index = 1;
//        // Traverse the remaining elements
//        for (int i = k; i < nums.length; i++) {
//            // Remove first element of previous window from BST
//            int freq = map.get(nums[i - k]);
//            if (freq == 1) {
//                map.remove(nums[i - k]);
//            } else {
//                map.put(nums[i - k], freq - 1);
//            }
//            
//            // Add current element to BST
//            if (map.containsKey(nums[i])) {
//                map.put(nums[i], map.get(nums[i]) + 1);
//            } else {
//                map.put(nums[i], 1);
//            }
//            
//            // Current asnwer is maximum value in BST
//            ans[index++] = map.lastKey();
//        }
//        
//        return ans;
//	}
	
	private Deque<Integer> deque = new LinkedList<>();

	public int[] maxSlidingWindow(int[] nums, int k) { int[] result = new int[nums.length-(k-1)]; int i = 0; for (i = 0; i < k;i++) { result[0] = maxBlackBox(nums,k, i); }

	for (; i < nums.length; i++) {
	  result[i - k + 1] = maxBlackBox(nums, k, i);
	}
	return result;   }
	private int maxBlackBox(int [] nums, int k, int i) { // Shart-2 while (!deque.isEmpty() && deque.peek() <= i - k) { deque.removeFirst(); }

	// Shart-1
	while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
	  deque.removeLast();
	}

	deque.addLast(i);
	return nums[deque.peek()];   
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