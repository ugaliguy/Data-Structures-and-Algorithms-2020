import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        //write your code here
    	int[] change = new int[m+1];
    	int[] denoms = {1,3,4};
    	change[0] = 0;
    	for (int i = 1; i <= m; i++) {
    		change[i] = Integer.MAX_VALUE;
    		for (int d : denoms) {
    			if (i >= d) {
    				change[i] = Math.min(change[i], change[i-d] + 1);
    			}
    		}
    	}
        return change[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
        scanner.close();
    }
}

