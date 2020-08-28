import java.util.*;

public class FibonacciHuge {
//    private static long getFibonacciHugeNaive(long n, long m) {
//        if (n <= 1)
//            return n;
//
//        long previous = 0;
//        long current  = 1;
//
//        for (long i = 0; i < n - 1; ++i) {
//            long tmp_previous = previous;
//            previous = current;
//            current = tmp_previous + current;
//        }
//
//        return current % m;
//    }
    
	private static ArrayList<Long> pisanoPeriod(long m) {
//		long prev = 0;
//		long curr = 1;
//		long next = 0;
		long result = 1;
		ArrayList<Long> pisano = new ArrayList<Long>();
		pisano.add(0L);
		pisano.add(1L);
		int i = 2;
		while(true) {
			pisano.add((pisano.get(i-1) + pisano.get(i-2))%m);
			i += 1;
			// Check for subsequence 01
			if (pisano.get(i-2) == 0 && pisano.get(i-1) == 1) {
				break;
			}
		}
//		System.out.println(Arrays.toString(pisano.toArray()));
//		System.out.println(pisano.size());
//		for (long i = 0; i < m*m; i++) {
//			next = (prev + curr) % m;
//			prev = curr;
//			curr = next;
//			if (prev == 0 && curr == 1) {
//				count = i + 1;
//				break;
//			}
//		}
		return pisano;
	}
	
    private static long getFibonacciHugeEfficient(long n, long m) {
        ArrayList<Long> p = pisanoPeriod(m);
        int period = p.size() - 2;
//        System.out.println(p);
        long remainder = n % period;
//        System.out.println(n);
//        if (m <= 1) {
//        	return m;
//        }
//        long prev = 0;
//        long curr = 1;
//        long next = 1;
//        for (long i = 0; i < n-1; i++) {
//        	next = (prev + curr) % m;
//        	prev = curr;
//        	curr = next;
////        	System.out.println(next);
//        }
        
        return remainder;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeEfficient(n, m));
        scanner.close();
    }
}

