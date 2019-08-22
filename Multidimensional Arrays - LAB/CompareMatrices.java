package JavaAdvancedLabs;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] rowsCols1 =
                Arrays.stream(in.nextLine().split(" "))
                .mapToInt(Integer:: new)
                .toArray();

        int R1 = rowsCols1[0];
        int C1 = rowsCols1[1];

        int[][] matrix1 = new int[R1][];

        for (int rows = 0; rows < matrix1.length; rows++) {
            matrix1[rows] =
                    Arrays.stream(in.nextLine().split(" "))
                    .limit(C1)
                    .mapToInt(Integer::new)
                    .toArray();
        }

        int[] rowsCols2 =
                Arrays.stream(in.nextLine().split(" "))
                        .mapToInt(Integer:: new)
                        .toArray();

        int[][] matrix2 = new int[rowsCols2[0]][];

        for (int rows = 0; rows < matrix2.length; rows++) {
            matrix2[rows] =
                    Arrays.stream(in.nextLine().split(" "))
                            .limit(rowsCols2[1])
                            .mapToInt(Integer::new)
                            .toArray();
        }

        boolean compare = comapreMatrices(matrix1,matrix2);
        if (compare){
            System.out.println("equal");
        }else {
            System.out.println("not equal");
        }


    }

    static boolean comapreMatrices(int[][] firstMatix, int[][] secondMatrix){
        if (firstMatix.length != secondMatrix.length){
            return false;
        }

        for (int row = 0; row < firstMatix.length; row++) {
            if (firstMatix[row].length != secondMatrix[row].length){
                return false;
            }
            for (int col = 0; col < firstMatix[row].length; col++) {
                if (firstMatix[row][col] != secondMatrix[row][col]){
                    return false;
                }
            }
        }

        return true;
    }
}
