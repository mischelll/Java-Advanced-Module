package JavaAdvancedExams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class TheGarden {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());
        List<List<String>> matrix = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            List<String> list2 = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());
            matrix.add(list2);
        }

        Map<String, Integer> vegetableCount = new LinkedHashMap<>();
        vegetableCount.put("C", 0);
        vegetableCount.put("P", 0);
        vegetableCount.put("L", 0);

        int harmedVegCount = 0;

        String command = "";
        while (!"End of Harvest".equals(command = reader.readLine())) {
            String[] data = command.split("\\s+");
            String action = data[0];

            if (action.equals("Harvest")) {
                int row = Integer.parseInt(data[1]);
                int col = Integer.parseInt(data[2]);

                harvest(matrix, vegetableCount, row, col);
            } else if (action.equals("Mole")) {
                int row = Integer.parseInt(data[1]);
                int col = Integer.parseInt(data[2]);
                String direction = data[3];

                harmedVegCount += mole(matrix, row, col, direction);
            }
        }

        printMatrix(matrix);

        vegetableCount.entrySet().forEach(e ->{
            if (e.getKey().equalsIgnoreCase("C")){
                System.out.printf("Carrots: %d%n",vegetableCount.get(e.getKey()));
            }else if (e.getKey().equalsIgnoreCase("P")){
                System.out.printf("Potatoes: %d%n",vegetableCount.get(e.getKey()));
            }else if (e.getKey().equalsIgnoreCase("L")){
                System.out.printf("Lettuce: %d%n",vegetableCount.get(e.getKey()));
            }
        });

        System.out.printf("Harmed vegetables: %d",harmedVegCount);
    }

    static void harvest(List<List<String>> matrix, Map<String, Integer> vegCount, int row, int col) {
        if (inRange(matrix, row, col)) {
            if (!matrix.get(row).get(col).equals(" ")) {
                String vegetebaleType = matrix.get(row).get(col);
                vegCount.put(vegetebaleType, vegCount.get(vegetebaleType) + 1);
                matrix.get(row).set(col, " ");
            }
        }
    }

    static int mole(List<List<String>> matrix, int row, int col, String direction) {
        int count = 0;

        if (direction.equalsIgnoreCase("Up")) {

            while (inRange(matrix, row, col)) {
                if (!matrix.get(row).get(col).equalsIgnoreCase(" ")) {
                    matrix.get(row).set(col, " ");
                    count++;
                }
                row -= 2;
            }

        } else if (direction.equalsIgnoreCase("Down")) {

            while (inRange(matrix, row, col)) {
                if (!matrix.get(row).get(col).equalsIgnoreCase(" ")) {
                    matrix.get(row).set(col, " ");
                    count++;
                }
                row += 2;
            }
        } else if (direction.equalsIgnoreCase("Left")) {

            while (inRange(matrix, row, col)) {
                if (!matrix.get(row).get(col).equalsIgnoreCase(" ")) {
                    matrix.get(row).set(col, " ");
                    count++;
                }
                col -= 2;
            }
        } else if (direction.equalsIgnoreCase("Right")) {
            while (inRange(matrix, row, col)) {
                if (!matrix.get(row).get(col).equalsIgnoreCase(" ")) {
                    matrix.get(row).set(col, " ");
                    count++;
                }
                col += 2;
            }
        }
        return count;
    }

    static boolean inRange(List<List<String>> field, int rows, int cols) {

        return rows >= 0 && rows < field.size() && cols >= 0 && cols < field.get(rows).size();
    }

    static void printMatrix(List<List<String>> matrix) {
        for (List<String> strings : matrix) {
            System.out.printf("%s%n", String.join(" ", strings));
        }
    }

}
