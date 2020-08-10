import java.util.*;

public class FibonacciPartialSum {
	
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
	
	private static ArrayList<Integer> pisano(int m) {
		int p = pisanoPeriod(m);
		ArrayList<Integer> remainders = new ArrayList<Integer>();
		int i = 2;
		remainders.add(0);
		remainders.add(1);
		do {
			remainders.add((remainders.get(i-1) + remainders.get(i-2)) % m);
			i += 1;
		} while (remainders.get(i-2) != 0 || remainders.get(i-1) != 1);
		return remainders;
	}
	
	private static long getFibonacciPartialSumEfficient(long from, long to) {
		
		if (to <= 1)
            return to;
		
		ArrayList<Integer> ones = pisano(10);
		int p = pisanoPeriod(10);
//		System.out.println(p);
		int m = (int) from % p;
		int n = (int) to % p;
		
		// Take advantage of the identity F_0 + F_1 + F_2 + ... +F_n = F_(n+2) - 1
		// Then F_from + ... F_to = F_(to + 2) - 1 - (F_(from + 1) - 1) = F_(to + 2) - F_(from + 1)
		
		ArrayList<Integer> fib = new ArrayList<>();
        fib.add(0);
        fib.add(1);
        
        for (int i = 2; i <= Math.max(m, n) + 2; i++) {
        	fib.add((fib.get(i-2) + fib.get(i-1)) % 10);
        }
        
        int r1 = fib.get(m+1);
        int r2 = fib.get(n+2);
        if (r2 >= r1) {
        	return r2 - r1;
        }
        else {
        	return 10 + r2 - r1;
        }

    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumEfficient(from, to));
        scanner.close();
    }
}

