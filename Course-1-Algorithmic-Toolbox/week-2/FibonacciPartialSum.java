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
	
	private static long getFibonacciPartialSumEfficient(long from, long to) {
		
		if (to <= 1)
            return to;
		
		ArrayList<Long> p = pisano(10);
        int period = p.size() - 2;
        Long m = from % period;
		Long n = to % period;
//        System.out.println(period);
        Long f2 =(n+2) % period;
        Long f1 =(m+1) % period;
//        System.out.println(remainder);
        Long result = p.get(f2.intValue()) - p.get(f1.intValue());
        return (result < 0) ? result + 10 : result;

    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumEfficient(from, to));
        scanner.close();
    }
}

