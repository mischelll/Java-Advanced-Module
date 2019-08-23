package JavaAdvancedExe;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] palindromes = new String[rows][cols];

        fillMatrix(palindromes);

    }

    static void printMatrix(String[][] matrix) {

        for (String[] strings : matrix) {
            System.out.println(Arrays.toString(strings).replaceAll("[\\[\\],]", ""));
        }
    }

    static void fillMatrix(String[][] matrix) {
        String firstElement = "aaa";
        String toAdd  = "aaa";


        for (int row = 0; row < matrix.length; row++) {
            matrix[row][0] = firstElement;
            for (int col = 1; col < matrix[row].length; col++) {
                char[] chars = toAdd.toCharArray();
                char c = (char) (chars[1] + 1);
                chars[1] = c;
                toAdd = new String(chars);
                matrix[row][col] = toAdd;

            }
            char[] chars = firstElement.toCharArray();
            chars[0] = (char)(chars[0] + 1);
            chars[1] = (char)(chars[1] + 1);
            chars[2] = (char)(chars[2] + 1);
            firstElement = new String(chars);
            toAdd = firstElement;
        }

        printMatrix(matrix);
    }
}
