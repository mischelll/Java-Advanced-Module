package JavaAdvancedExams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sneaking {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<List<String>> matrix = new ArrayList<>();
        int numRows = Integer.parseInt(reader.readLine());
        int numCols = 0;
        for (int row = 0; row < numRows; row++) {
            List<String> list2 = Arrays.stream(reader.readLine().split("")).collect(Collectors.toList());
            matrix.add(list2);
        }
        numCols = matrix.get(0).size();

        int samRow = 0;
        int samCol = 0;

        int nikoladzeRow = 0;
        int nikoladzeCol = 0;

        for (int row = 0; row < matrix.size(); row++) {
            for (int col = 0; col < matrix.get(row).size(); col++) {
                String current = matrix.get(row).get(col);
                if (current.equals("N")) {
                    nikoladzeRow = row;
                    nikoladzeCol = col;
                } else if (current.equals("S")) {
                    samRow = row;
                    samCol = col;
                }
            }
        }
        
        boolean samDead = false;
        boolean nikoladzeDead = false;
        
        String[] directions = reader.readLine().split("");
        for (int i = 0; i < directions.length; i++) {
            String direction = directions[i];
            int[] data = moveMatrix(matrix, direction, samRow, samCol, nikoladzeRow, nikoladzeCol);
            samRow = data[0];
            samCol = data[1];
            if (matrix.get(nikoladzeRow).get(nikoladzeCol).equals("X")) {
                nikoladzeDead = true;
                System.out.println("Nikoladze killed!");
                break;
            } else if (matrix.get(data[0]).get(data[1]).equals("X")) {
                samDead = true;
                System.out.printf("Sam died at %d, %d%n", samRow, samCol);
                break;
            }
        }
            
        printMatrix(matrix);

    }

    static int[] moveMatrix(List<List<String>> matrix, String direction, int samRow, int samCol, int nikoladzeRow, int nikoladzeCol) {
        int[] data = new int[2];

        findGuards(matrix);
        if (direction.equals("U")) {
            if (matrix.get(samRow - 1).get(samCol).equals("d") && matrix.get(samRow - 1).get(samCol).equals("b")) {
                matrix.get(samRow).set(samCol, ".");
                matrix.get(samRow - 1).set(samCol, "S");
            } else if (samRow - 1 == nikoladzeRow) {
                matrix.get(samRow).set(samCol, ".");
                matrix.get(samRow - 1).set(samCol, "S");
                matrix.get(nikoladzeRow).set(nikoladzeCol, "X");
            } else if (isGuardWatching(matrix, samRow, samCol)) {
                matrix.get(samRow).set(samCol, "X");
                data[0] = samRow;
                data[1] = samCol;
                return data;
            } else {
                matrix.get(samRow).set(samCol, ".");
                matrix.get(samRow - 1).set(samCol, "S");
            }

            samRow = samRow - 1;
            data[0] = samRow;
            data[1] = samCol;
            
        } else if (direction.equals("D")) {
            if (matrix.get(samRow + 1).get(samCol).equals("d") || matrix.get(samRow + 1).get(samCol).equals("b")) {
                matrix.get(samRow).set(samCol, ".");
                matrix.get(samRow + 1).set(samCol, "S");
            } else if (samRow + 1 == nikoladzeRow) {
                matrix.get(samRow).set(samCol, ".");
                matrix.get(samRow + 1).set(samCol, "S");
                matrix.get(nikoladzeRow).set(nikoladzeCol, "X");
            } else if (isGuardWatching(matrix, samRow, samCol)) {
                matrix.get(samRow).set(samCol, "X");
                data[0] = samRow;
                data[1] = samCol;
                return data;
            } else {
                matrix.get(samRow).set(samCol, ".");
                matrix.get(samRow + 1).set(samCol, "S");
            }
            samRow = samRow + 1;
            data[0] = samRow;
            data[1] = samCol;
            
        } else if (direction.equals("L")) {
            if (matrix.get(samRow).get(samCol - 1).equals("d") || matrix.get(samRow).get(samCol - 1).equals("b")) {
                matrix.get(samRow).set(samCol, ".");
                matrix.get(samRow).set(samCol - 1, "S");
            } else if (samRow == nikoladzeRow) {
                matrix.get(samRow).set(samCol, ".");
                matrix.get(samRow).set(samCol - 1, "S");
                matrix.get(nikoladzeRow).set(nikoladzeCol, "X");
            } else if (isGuardWatching(matrix, samRow, samCol)) {
                matrix.get(samRow).set(samCol, "X");
                data[0] = samRow;
                data[1] = samCol;
                return data;
            } else {
                matrix.get(samRow).set(samCol, ".");
                matrix.get(samRow).set(samCol - 1, "S");
            }
            samCol = samCol - 1;
            data[0] = samRow;
            data[1] = samCol;
            
        } else if (direction.equals("R")) {
            if (matrix.get(samRow).get(samCol + 1).equals("d") || matrix.get(samRow).get(samCol + 1).equals("b")) {
                matrix.get(samRow).set(samCol, ".");
                matrix.get(samRow).set(samCol + 1, "S");
            } else if (samRow == nikoladzeRow) {
                matrix.get(samRow).set(samCol, ".");
                matrix.get(samRow).set(samCol + 1, "S");
                matrix.get(nikoladzeRow).set(nikoladzeCol, "X");
            } else if (isGuardWatching(matrix, samRow, samCol)) {
                matrix.get(samRow).set(samCol, "X");
                data[0] = samRow;
                data[1] = samCol;
                return data;
            } else {
                matrix.get(samRow).set(samCol, ".");
                matrix.get(samRow).set(samCol + 1, "S");
            }
            samCol = samCol + 1;
            data[0] = samRow;
            data[1] = samCol;
            
        } else if (direction.equals("W")) {
            data[0] = samRow;
            data[1] = samCol;
        }

        return data;
    }

    static void findGuards(List<List<String>> matrix) {
        for (int row = 0; row < matrix.size(); row++) {
            for (int col = 0; col < matrix.get(row).size(); col++) {
                String current = matrix.get(row).get(col);
                if (current.equals("b")) {
                    int gRow = row;
                    int gCol = col;
                    moveGuards(matrix, gRow, gCol, current);
                    break;
                } else if (current.equals("d")) {
                    int gRow = row;
                    int gCol = col;
                    moveGuards(matrix, gRow, gCol, current);
                    break;
                }
            }
        }
    }

    static void moveGuards(List<List<String>> matrix, int row, int col, String type) {
        if (type.equals("b")) {
            if (isEdge(matrix, row, col, type)) {
                matrix.get(row).set(col, "d");
                return;

            }
            matrix.get(row).set(col, ".");
            matrix.get(row).set(col + 1, type);

        } else if (type.equals("d")) {
            if (isEdge(matrix, row, col, type)) {
                matrix.get(row).set(col, "b");
                return;
            }
            matrix.get(row).set(col, ".");
            matrix.get(row).set(col - 1, type);

        }
    }

    static boolean isEdge(List<List<String>> matrix, int row, int col, String type) {
        if (type.equals("b")) {
            if (col == matrix.get(0).size() - 1) {
                return true;
            }
        } else if (type.equals("d")) {
            if (col == 0) {
                return true;
            }
        }

        return false;
    }

    static boolean isGuardWatching(List<List<String>> matrix, int samRow, int samCol) {
        for (int row = 0; row < matrix.size(); row++) {
            for (int col = 0; col < matrix.get(row).size(); col++) {
                String current = matrix.get(row).get(col);
                if (current.equals("b")) {
                    int gRow = row;
                    int gCol = col;
                    if (gRow == samRow && samCol > gCol) {
                        return true;
                    }
                } else if (current.equals("d")) {
                    int gRow = row;
                    int gCol = col;
                    if (gRow == samRow && samCol < gCol) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static void printMatrix(List<List<String>> matrix) {
        for (List<String> strings : matrix) {
            System.out.printf("%s%n", String.join("", strings));
        }
    }
}
