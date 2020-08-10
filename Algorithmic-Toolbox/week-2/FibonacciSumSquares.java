import java.util.*;

public class FibonacciSumSquares {

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
		} while (i < p);
//		for (Integer d: remainders) {
//			System.out.print(d);
//		}
//		System.out.println(" ");
		return remainders;
	}
	
	private static long getFibonacciSumSquaresEfficient(long n) {
		if (n <= 1)
            return n;
		
		ArrayList<Integer> ones = pisano(10);
		int p = pisanoPeriod(10);

		// Take advantage of the identity F_0^2 + F_1^2 + F_2^2 + ... +F_n^2 = F_n * F_(n+1)
		
        long n1 = n % p;
        long np1  = (n+1) % p;
        long product = (ones.get((int)n1)*ones.get((int)np1)) % p;

        return product % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquaresEfficient(n);
        System.out.println(s);
    }
}

