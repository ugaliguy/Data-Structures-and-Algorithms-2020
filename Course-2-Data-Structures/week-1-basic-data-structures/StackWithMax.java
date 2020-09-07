import java.util.*;
import java.io.*;

public class StackWithMax {
//	private Stack<Integer> data;
//	private Stack<Integer> max;
//
//	public StackWithMax() {
//		data = new Stack<Integer>();
//		max = new Stack<Integer>();
//	}
//
//	public void push(int x) {
//		data.push(x);
//		if (max.empty() || x >= max())
//			max.push(x);
//	}
//
//	public int pop() {
//		if (data.peek() == max())
//			max.pop();
//		return data.pop();
//	}
//
//	public int peek() {
//		return data.peek();
//	}
//
//	public int max() {
//		return max.peek();
//	}
	
	  Stack<Integer> stack;
	  Stack<Integer> maxStack;

	  public StackWithMax() {
	    stack = new Stack<>();
	    maxStack = new Stack<>();
	  }

	  public Integer max() {
	    if (!maxStack.isEmpty()) {
	      return maxStack.peek();
	    }
	    return -1;
	  }

	  public Integer pop() {
	    if (stack.isEmpty()) {
	      return -1;
	    }
	    int popped = stack.pop();
	    maxStack.pop();
	    return popped;
	  }

	  public void push(Integer x) {
	    stack.push(x);
	    if (maxStack.isEmpty()) {
	      maxStack.push(x);
	    } else {
	      maxStack.push(Math.max(maxStack.peek(), x));
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
