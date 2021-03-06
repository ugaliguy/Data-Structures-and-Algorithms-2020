import java.util.*;

public class FibonacciSumLastDigit {
	
	// Take advantage of the identity F_0 + F_1 + F_2 + ... +F_n = F_(n+2) - 1
	
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
	
	private static ArrayList<Long> pisano(int m) {
		int p = pisanoPeriod(m);
		ArrayList<Long> remainders = new ArrayList<Long>();
		int i = 2;
		remainders.add(0L);
		remainders.add(1L);
		do {
			remainders.add((remainders.get(i-1) + remainders.get(i-2)) % m);
			i += 1;
		} while (remainders.get(i-2) != 0 || remainders.get(i-1) != 1);
		return remainders;
	}
	
    private static long getFibonacciSumEfficient(long n) {
    	ArrayList<Long> p = pisano(10);
        int period = p.size() - 2;
//        System.out.println(period);
        Long remainder =(n+2) % period;
//        System.out.println(remainder);
        Long result = p.get(remainder.intValue());
        return (result == 0) ? 9 : result - 1;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumEfficient(n);
        System.out.println(s);
        scanner.close();
    }
}

