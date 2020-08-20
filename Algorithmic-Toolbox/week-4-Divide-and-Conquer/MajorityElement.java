import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
//        if (left == right) {
//            return -1;
//        }
//        if (left + 1 == right) {
//            return a[left];
//        }
        //write your code here
    	int n = a.length;
    	int mid = n/2;
//    	int count = 0;
    	HashMap<Integer,Integer> counts = new HashMap<Integer,Integer>();
    	for (int i = 0; i < n; i++) {
    		if (counts.containsKey(a[i])) {
    			int count = counts.get(a[i]) + 1;
    			if (count > mid) {
    				return 1;
    			}
    			else {
    				counts.put(a[i], count);
    			}
    		}
    		else {
    			counts.put(a[i], 1);
    		}
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
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
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

