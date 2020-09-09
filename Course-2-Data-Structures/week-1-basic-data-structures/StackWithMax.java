import java.util.*;
import java.io.*;

public class StackWithMax {

	//Declare two stacks
    private Stack<Integer> st = new Stack<>();
    private Stack<Integer> maxSt = new Stack<>();
    
    public StackWithMax() {
		st = new Stack<Integer>();
		maxSt = new Stack<Integer>();
	}
 
    public void push(int data) {   	
    	if (data >= max()) {
            maxSt.push(data);
        }
        st.push(data);
    }
 
    public void pop() {
        st.pop();
        maxSt.pop();
    }
 
    public int max() {
    	if (maxSt.isEmpty()) {
            return Integer.MIN_VALUE;
        } else {
            return maxSt.peek();
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
        int queries = scanner.nextInt();
        Stack<Integer> stack = new Stack<Integer>();

        for (int qi = 0; qi < queries; ++qi) {
            String operation = scanner.next();
            if ("push".equals(operation)) {
                int value = scanner.nextInt();
                stack.push(value);
            } else if ("pop".equals(operation)) {
                stack.pop();
            } else if ("max".equals(operation)) {
                System.out.println(Collections.max(stack));
            }
        }
    }

    static public void main(String[] args) throws IOException {
        new StackWithMax().solve();
    }
}
