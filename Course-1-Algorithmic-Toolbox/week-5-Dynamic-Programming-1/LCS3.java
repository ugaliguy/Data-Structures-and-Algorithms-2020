import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
        //Write your code here
    	int al = a.length;
    	int bl = b.length;
    	int cl = c.length;
    	int[][][] mat = new int[al + 1][bl + 1][cl + 1];

        for (int i = 1; i <= al; i++) {
            for (int j = 1; j <= bl; j++) {
                for (int k = 1; k <= cl; k++)
                    if (a[i - 1] == b[j - 1] && b[j - 1] == c[k - 1]) {
                        mat[i][j][k] = mat[i - 1][j - 1][k - 1] + 1;
                    } else {
                        mat[i][j][k] = Math.max(mat[i][j][k - 1], Math.max(mat[i - 1][j][k], mat[i][j - 1][k]));
                    }
            }
        }
        return mat[a.length][b.length][c.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

