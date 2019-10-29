package JavaAdvancedExe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatrixRotation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<String> data = new ArrayList<>();

        String input = in.nextLine();
        while (!input.equals("END")) {
            data.add(input);

            input = in.nextLine();
        }

        int maxLength = 0;

        for (int i = 1; i < data.size(); i++) {
            if (data.get(i).length() > maxLength) {
                maxLength = data.get(i).length();
            }
        }

        int index = 1;
        char[][] matrix = new char[data.size() - 1][maxLength];
        for (int row = 0; row < matrix.length; row++) {
            char[] arr = data.get(index).toCharArray();
            int index2 = 0;

            for (int col = 0; col < matrix[row].length; col++) {

                if (index2 >= arr.length) {
                    Arrays.fill(matrix[row], col, matrix[row].length, ' ');
                    break;
                } else {
                    matrix[row][col] = arr[index2];
                    index2++;
                }

            }
            index++;
        }

        rotateMatrix(matrix, data.get(0), maxLength);

    }

    static void rotateMatrix(char[][] matrix, String rotation, int maxLength) {
        if (rotation.equals("Rotate(0)")) {
            printMatrix(matrix);

        } else if (rotation.equals("Rotate(90)")) {

            for (int col = 0; col < maxLength; col++) {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (rotation.equals("Rotate(180)")) {

            for (int row = matrix.length - 1; row >= 0; row--) {
                for (int col = matrix[row].length - 1; col >= 0; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }

        } else if (rotation.equals("Rotate(270)")) {
            for (int col = maxLength - 1; col >= 0; col--) {
                for (int row = 0; row < matrix.length; row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }

        } else if (rotation.equals("Rotate(360")) {
            printMatrix(matrix);

        } else {
            int num = 0;

            String regex = "[\\d]+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(rotation);

            if (matcher.find()) {
                num = Integer.parseInt(matcher.group());
            }

            int times = num - 360;

            String[] rotations = {"Rotate(0)", "Rotate(90)", "Rotate(180)", "Rotate(270)", "Rotate(360)"};

            String str = "";


            while (times > 360) {
                times -= 360;
            }

            switch (times) {
                case 0:
                    str = rotations[0];
                    break;
                case 90:
                    str = rotations[1];
                    break;
                case 180:
                    str = rotations[2];
                    break;
                case 270:
                    str = rotations[3];
                    break;
                case 360:
                    str = rotations[4];
                    break;
            }

            rotateMatrix(matrix, str, maxLength);

        }


    }

    static void printMatrix(char[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
