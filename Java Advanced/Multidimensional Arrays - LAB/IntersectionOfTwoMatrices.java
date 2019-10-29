package JavaAdvancedLabs;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int rows = Integer.parseInt(in.nextLine());
        int cols = Integer.parseInt(in.nextLine());

        char[][] matrix1 = new char[rows][cols];
        char[][] matrix2 = new char[rows][cols];
        char[][] matrix3 = new char[rows][cols];

        for (int row = 0; row < matrix1.length; row++) {
            String[] input = in.nextLine().split("\\s+");
            for (int col = 0; col < matrix1[row].length; col++) {
                matrix1[row][col] = input[col].charAt(0);
            }
        }

        for (int row = 0; row < matrix2.length; row++) {
            String[] input = in.nextLine().split("\\s+");
            for (int col = 0; col < matrix2[row].length; col++) {
                matrix2[row][col] = input[col].charAt(0);
            }
        }

        for (int row = 0; row < matrix1.length; row++) {
            for (int col = 0; col < matrix1[row].length; col++) {
                char c = matrix1[row][col];
                char d = matrix2[row][col];

                if (c == d){
                    matrix3[row][col] = c;
                }else {
                    matrix3[row][col] = '*';
                }
            }
        }

        for (char[] chars : matrix3) {
            System.out.println(Arrays.toString(chars).replaceAll("[\\[\\],]", ""));
        }


        System.out.println();
    }
}
