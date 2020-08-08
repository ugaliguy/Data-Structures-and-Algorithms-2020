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
    
	private static long pisanoPeriod(long m) {
		long prev = 0;
		long curr = 1;
		long next = 0;
		long count = 0;
		for (long i = 0; i < m*m; i++) {
			next = (prev + curr) % m;
			prev = curr;
			curr = next;
			if (prev == 0 && curr == 1) {
				count = i + 1;
				break;
			}
		}
		return count;
	}
	
    private static long getFibonacciHugeEfficient(long n, long m) {
        long p = pisanoPeriod(m);
//        System.out.println(p);
        n = n % p;
        if (m <= 1) {
        	return m;
        }
        long prev = 0;
        long curr = 1;
        long next = 0;
        for (long i = 0; i < n-1; i++) {
        	next = (prev + curr) % m;
        	prev = curr;
        	curr = next;
        }
        return next % m;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeEfficient(n, m));
        scanner.close();
    }
}

