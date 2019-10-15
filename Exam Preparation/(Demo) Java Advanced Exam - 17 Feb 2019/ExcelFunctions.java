package JavaAdvancedExams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class ExcelFunctions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        List<List<String>> matrix = new ArrayList<>();

        for (int row = 0; row < N; row++) {
            List<String> list2 = Arrays.stream(reader.readLine().split(", ")).collect(Collectors.toList());
            matrix.add(list2);
        }

        String[] data = reader.readLine().split("\\s+");
        if (data[0].equals("sort")) {
            matrix = sort(matrix, data[1]);
        } else if (data[0].equals("hide")) {
            hide(matrix, data[1]);
        } else if (data[0].equals("filter")) {
            filter(matrix, data[1], data[2]);
        }

        for (List<String> strings : matrix) {
            System.out.println(String.join(" | ", strings));

        }
        System.out.println();
    }

    static List<List<String>> sort(List<List<String>> matrix, String header) {
        int headerIndex = 0;
        for (String s : matrix.get(0)) {
            if (s.equals(header)) {
                headerIndex = matrix.get(0).indexOf(s);
            }
        }
        int num = headerIndex;

        List<String> keepHeader = new ArrayList<>();
        keepHeader = matrix.get(0);
        matrix.remove(0);

        matrix = matrix.stream().sorted(Comparator.comparing(a -> a.get(num))).collect(Collectors.toList());

        matrix.add(0, keepHeader);
        return matrix;
    }

    static List<List<String>> hide(List<List<String>> matrix, String header) {
        int headerIndex= 0;
        for (String s : matrix.get(0)) {
            if (s.equals(header)) {
                headerIndex = matrix.get(0).indexOf(s);
            }
        }

        int n = matrix.size();
        int counter = 0;
        while (n-- > 0) {
            matrix.get(counter).remove(headerIndex);
            counter++;
        }

        return matrix;
    }

    static List<List<String>> filter(List<List<String>> matrix, String header, String value) {
        int headerIndex = 0;
        for (String s : matrix.get(0)) {
            if (s.equals(header)) {
                headerIndex = matrix.get(0).indexOf(s);
            }
        }

        List<String> keepHeader = new ArrayList<>();
        keepHeader = matrix.get(0);
        matrix.remove(0);

        List<List<String>> keepValue = new ArrayList<>();
        for (int row = 0; row < matrix.size(); row++) {
            for (int col = 0; col < matrix.get(row).size(); col++) {
                if (matrix.get(row).get(col).equals(value)) {
                    keepValue.add(matrix.get(row));

                }

            }
        }

        matrix.clear();

        matrix.add(0, keepHeader);
        int counter = 1;
        for (List<String> strings : keepValue) {
            matrix.add(counter,strings);
            counter++;
        }

        return matrix;
    }
}
