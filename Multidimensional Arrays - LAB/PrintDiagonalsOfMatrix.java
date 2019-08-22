package JavaAdvancedLabs;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        int[][] matrix =  new int[n][n];

        for (int row = 0; row < matrix.length ; row++) {
            matrix[row] =
                    Arrays.stream(in.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int num1 = matrix.length- 1;
        int num2 = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                if (row == col){
                    System.out.print(matrix[row][col] + " ");
                }

            }

        }
        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[num1][num2] + " ");
            num1--;
            num2++;
        }
    }
}
