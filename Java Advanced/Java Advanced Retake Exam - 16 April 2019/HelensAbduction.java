package JavaAdvancedExams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HelensAbduction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<List<String>> field = new ArrayList<>();
        int energy = Integer.parseInt(reader.readLine());
        int numRows = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numRows; i++) {
            List<String> cols = Arrays.stream(reader.readLine().split("")).collect(Collectors.toList());
            field.add(cols);
        }

        int parisRow = 0;
        int parisCol = 0;

        int helenRow = 0;
        int helenCol = 0;
        for (int row = 0; row < field.size(); row++) {
            for (int col = 0; col < field.get(row).size(); col++) {
                String current = field.get(row).get(col);
                if (current.equals("P")) {
                    parisRow = row;
                    parisCol = col;
                }

                if (current.equals("H")) {
                    helenRow = row;
                    helenCol = col;
                }
            }
        }

        boolean parisDead = false;
        boolean helenAbducted = false;

        while (energy > 0) {
            String[] input = reader.readLine().split("\\s+");
            String direction = input[0];
            int rowSpartan = Integer.parseInt(input[1]);
            int colSpartan = Integer.parseInt(input[2]);
            field.get(rowSpartan).set(colSpartan, "S");

            int[] newPositionAndEnergy = moveParis(field, direction, parisRow, parisCol, energy);
            parisRow = newPositionAndEnergy[0];
            parisCol = newPositionAndEnergy[1];
            energy = newPositionAndEnergy[2];

            if ((parisRow == helenRow) && (parisCol == helenCol)) {
                field.get(parisRow).set(parisCol, "-");
                field.get(helenRow).set(helenCol, "-");
                helenAbducted = true;
                break;
            } else {
                if (energy <= 0) {
                    field.get(parisRow).set(parisCol, "X");
                    parisDead = true;
                    break;
                }
            }
        }

        if (parisDead){
            System.out.printf("Paris died at %d;%d.%n",parisRow,parisCol);
            printMatrix(field);
        }else if (helenAbducted){
            System.out.print("Paris has successfully abducted Helen!");
            System.out.printf(" Energy left: %d%n",energy);
            printMatrix(field);
        }

    }

    static int[] moveParis(List<List<String>> field, String direction, int parisRow, int parisCol, int energy) {
        int[] newPositionAndEnergy = new int[3];

        if (direction.equals("up")) {
            if (inRange(field, parisRow - 1, parisCol)) {
                field.get(parisRow ).set(parisCol, "-");
                if (!field.get(parisRow - 1).get(parisCol).equals("S")) {
                    energy -= 1;
                    field.get(parisRow - 1).set(parisCol, "P");
                } else {
                    energy -= 3;
                    field.get(parisRow - 1).set(parisCol, "P");
                }
                parisRow = parisRow - 1;
                newPositionAndEnergy[0] = parisRow;
                newPositionAndEnergy[1] = parisCol;
            } else {
                energy -= 1;
                newPositionAndEnergy[0] = parisRow;
                newPositionAndEnergy[1] = parisCol;
            }
        } else if (direction.equals("down")) {
            if (inRange(field, parisRow + 1, parisCol)) {
                field.get(parisRow ).set(parisCol, "-");
                if (!field.get(parisRow + 1).get(parisCol).equals("S")) {
                    energy -= 1;
                    field.get(parisRow + 1).set(parisCol, "P");
                } else {
                    energy -= 3;
                    field.get(parisRow + 1).set(parisCol, "P");
                }
                parisRow = parisRow + 1;
                newPositionAndEnergy[0] = parisRow;
                newPositionAndEnergy[1] = parisCol;
            } else {
                energy -= 1;
                newPositionAndEnergy[0] = parisRow;
                newPositionAndEnergy[1] = parisCol;
            }
        } else if (direction.equals("right")) {
            if (inRange(field, parisRow, parisCol + 1)) {
                field.get(parisRow ).set(parisCol, "-");
                if (!field.get(parisRow).get(parisCol + 1).equals("S")) {
                    energy -= 1;
                    field.get(parisRow).set(parisCol + 1, "P");
                } else {
                    energy -= 3;
                    field.get(parisRow).set(parisCol + 1, "P");
                }
                parisCol = parisCol + 1;
                newPositionAndEnergy[0] = parisRow;
                newPositionAndEnergy[1] = parisCol;
            } else {
                energy -= 1;
                newPositionAndEnergy[0] = parisRow;
                newPositionAndEnergy[1] = parisCol;
            }

        } else if (direction.equals("left")) {
            if (inRange(field, parisRow, parisCol - 1)) {
                field.get(parisRow ).set(parisCol, "-");
                if (!field.get(parisRow).get(parisCol - 1).equals("S")) {
                    energy -= 1;
                    field.get(parisRow).set(parisCol - 1, "P");
                } else {
                    energy -= 3;
                    field.get(parisRow).set(parisCol - 1, "P");
                }
                parisCol = parisCol - 1;
                newPositionAndEnergy[0] = parisRow;
                newPositionAndEnergy[1] = parisCol;
            } else {
                energy -= 1;
                newPositionAndEnergy[0] = parisRow;
                newPositionAndEnergy[1] = parisCol;
            }

        }

        newPositionAndEnergy[2] = energy;

        return newPositionAndEnergy;
    }

    static boolean inRange(List<List<String>> field, int rows, int cols) {

        return rows >= 0 && rows < field.size() && cols >= 0 && cols < field.get(rows).size();
    }

    static void printMatrix(List<List<String>> matrix){
        for (List<String> strings : matrix) {
            System.out.printf("%s%n",String.join("",strings));
        }
    }
}
