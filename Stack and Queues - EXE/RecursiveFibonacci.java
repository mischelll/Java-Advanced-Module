package JavaAdvancedExe;

import java.util.Scanner;

public class RecursiveFibonacci {

    static long[] memoArr;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        memoArr = new long[n + 1];
        System.out.println(fibonacciWithMemoization(n));
    }

    static long fibonacciWithMemoization(int n) {
        if (n <= 1) {
            return 1;
        }
        if (memoArr[n] != 0) {
            return memoArr[n];
        }

        memoArr[n] = fibonacciWithMemoization(n - 1) + fibonacciWithMemoization(n - 2);

        return memoArr[n];
    }
}
