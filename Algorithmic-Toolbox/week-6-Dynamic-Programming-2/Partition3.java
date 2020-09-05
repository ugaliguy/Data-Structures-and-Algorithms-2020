import java.util.*;
import java.io.*;

public class Partition3 {
	private static int partition3(int[] A) {
		int a = A.length;
        int sum = 0;
        for (int i = 0; i < a; i++) {
        	sum += A[i];
        }
        if (sum < 3 || sum % 3 != 0)
            return 0;

        int[][] tab = new int[sum / 3 + 1][a + 1];

        for (int i = 1; i <= sum / 3; i++) {

            for (int j = 1; j <= A.length; j++) {
                int diff = i - A[j - 1];
                if (A[j - 1] == i || (diff > 0 && tab[diff][j - 1] > 0)) {
                    tab[i][j] = tab[i][j - 1] == 0 ? 1 : 2;
                } else {
                    tab[i][j] = tab[i][j - 1];
                }
            }
        }
        //write your code here
        if (tab[sum / 3][A.length] == 2) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
        scanner.close();
    }
}

