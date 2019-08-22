package JavaAdvancedLabs;

import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char[][] matrix = new char[8][8];
        int properRow = 0;
        int properCol = 0;

        for (int row = 0; row < matrix.length; row++) {
            String[] input = in.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = input[col].charAt(0);
            }

        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'q') {
                    int probableRow = row;
                    int probableCol = col;

                    boolean up = checkUpwards(matrix, probableRow, probableCol);
                    if (up) {
                        boolean down = checkDownwards(matrix, probableRow, probableCol);
                        if (down) {
                            boolean left = checkLeft(matrix, probableRow, probableCol);
                            if (left){
                                boolean right = checkRight(matrix, probableRow, probableCol);
                                if (right){
                                    boolean mainDiagonal1 = checkMainDiagonal1(matrix, probableRow, probableCol);
                                    if (mainDiagonal1){
                                        boolean mainDiagonal2 = checkMainDiagonal2(matrix, probableRow, probableCol);
                                        if (mainDiagonal2){
                                            boolean otherDiagonal1 = checkOtherDiagonal1(matrix, probableRow, probableCol);
                                            if (otherDiagonal1){
                                                boolean otherDiagonal2 = checkOtherDiagonal2(matrix, probableRow, probableCol);
                                                if (otherDiagonal2){
                                                    System.out.println(row + " " + col);
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            }

        }


    }

    static boolean checkUpwards(char[][] matrix, int probableRow, int probableCol) {

        while (probableRow-- > 0) {
            boolean check = matrix[probableRow][probableCol] == 'q';
            if (check) {
                return false;
            }
        }
        return true;
    }

    static boolean checkDownwards(char[][] matrix, int probableRow, int probableCol) {

        while (probableRow++ < matrix.length - 1) {
            boolean check = matrix[probableRow][probableCol] == 'q';
            if (check) {
                return false;
            }
        }
        return true;
    }

    static boolean checkLeft(char[][] matrix, int probableRow, int probableCol) {

        while (probableCol-- > 0) {
            boolean check = matrix[probableRow][probableCol] == 'q';
            if (check) {
                return false;
            }
        }



        return true;

    }

    static boolean checkRight(char[][] matrix, int probableRow, int probableCol) {

        while (probableCol++ < matrix[probableRow].length - 1) {
            boolean check = matrix[probableRow][probableCol] == 'q';
            if (check) {
                return false;
            }
        }
        return true;
    }

    static boolean checkMainDiagonal1(char[][] matrix, int probableRow, int probableCol) {

        while (probableCol++ < matrix[probableRow].length - 1 && probableRow++ < matrix.length - 1) {
            boolean check = matrix[probableRow][probableCol] == 'q';
            if (check) {
                return false;
            }
        }
        return true;
    }

    static boolean checkMainDiagonal2(char[][] matrix, int probableRow, int probableCol) {

        while (probableCol-- > 0 && probableRow-- > 0) {
            boolean check = matrix[probableRow][probableCol] == 'q';
            if (check) {
                return false;
            }
        }
        return true;
    }

    static boolean checkOtherDiagonal1(char[][] matrix, int probableRow, int probableCol) {
        while (probableCol++ < matrix[probableRow].length - 1 && probableRow-- > 0) {
            boolean check = matrix[probableRow][probableCol] == 'q';
            if (check) {
                return false;
            }
        }
        return true;
    }

    static boolean checkOtherDiagonal2(char[][] matrix, int probableRow, int probableCol) {
        while (probableCol-- > 0 && probableRow++ < matrix.length - 1) {
            boolean check = matrix[probableRow][probableCol] == 'q';
            if (check) {
                return false;
            }
        }
        return true;
    }

}
