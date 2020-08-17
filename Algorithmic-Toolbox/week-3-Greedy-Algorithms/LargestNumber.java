import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
    	Comparator<String> comp = (x,y) -> {
    		int xy = Integer.parseInt(x + y);
    		int yx = Integer.parseInt(y + x);
    		return xy > yx ? -1: 1;
    	};
    	Arrays.sort(a, comp);
        String result = "";
        for (String number: a) {
            result += number;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

