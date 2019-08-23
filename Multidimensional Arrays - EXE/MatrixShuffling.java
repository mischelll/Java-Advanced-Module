package JavaAdvancedExe;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] input = in.nextLine().split(" ");

        int rowsCount = Integer.parseInt(input[0]);
        int colsCount = Integer.parseInt(input[1]);
        String[][] matrix = new String[rowsCount][colsCount];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = in.nextLine().split(" ");
        }

        String command = in.nextLine();
        while (!command.equals("END")) {

            String[] data = command.split(" ");

            if (!data[0].equals("swap") || data.length != 5) {
                System.out.println("Invalid input!");
            } else {
                int row1 = Integer.parseInt(data[1]);
                int col1 = Integer.parseInt(data[2]);
                int row2 = Integer.parseInt(data[3]);
                int col2 = Integer.parseInt(data[4]);

                boolean checkRow1 = row1 >= matrix.length;
                boolean checkRow2 = row2 >= matrix.length;

                if (!checkRow1 && !checkRow2) {
                    boolean checkCol1 = col1 >= matrix[row1].length;
                    boolean checkCol2 = col2 >= matrix[row2].length;
                    if (!checkCol1 && !checkCol2) {
                        String temp = "";

                        temp = matrix[row1][col1];
                        matrix[row1][col1] = matrix[row2][col2];
                        matrix[row2][col2] = temp;

                        printMatrix(matrix);
                    }
                } else {
                    System.out.println("Invalid input!");
                }

            }

            command = in.nextLine();
        }

    }

    static void printMatrix(String[][] matrix) {

        for (String[] strings : matrix) {
            System.out.println(Arrays.toString(strings).replaceAll("[\\[\\],]", ""));
        }
    }
}
