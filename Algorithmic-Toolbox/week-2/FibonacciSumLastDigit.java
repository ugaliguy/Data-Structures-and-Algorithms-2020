import java.util.*;

public class FibonacciSumLastDigit {
//    private static long getFibonacciSumNaive(long n) {
//        if (n <= 1)
//            return n;
//
//        long previous = 0;
//        long current  = 1;
//        long sum      = 1;
//
//        for (long i = 0; i < n - 1; ++i) {
//            long tmp_previous = previous;
//            previous = current % 10;
//            current = (tmp_previous + current) % 10;
//            sum = (sum + current) % 10;
//        }
//
//        return sum % 10;
//    }
    
	private static int pisanoPeriod(long m) {
		long prev = 0;
		long curr = 1;
		long next = 0;
		int count = 0;
		for (int i = 0; i < m*m; i++) {
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
	
	private static int[] pisano(int m) {
		int p = pisanoPeriod(m);
		int[] remainders = new int[m*m];
		remainders[0] = 0;
		remainders[1] = 1;
		for (int i = 2; i < m*m; i++) {
			remainders[i] = (remainders[i-1] + remainders[i-2]) % m;
			if (remainders[i-1] == 0 && remainders[i] == 1) {
				break;
			}
		}
		return remainders;
	}
	
    private static long getFibonacciSumEfficient(long n) {
    	int p = pisanoPeriod(10);
    	int[] lastDigits = pisano(p);
    	System.out.println(Arrays.toString(lastDigits));
    	System.out.println(p);
    	
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current % 10;
            current = (tmp_previous + current) % 10;
            sum = (sum + current) % 10;
        }

        return sum % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumEfficient(n);
        System.out.println(s);
    }
}

