package JavaAdvancedExe.genericSwapMethodInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Integer> list = new ArrayList<>();
        while (n-- > 0) {
            int string = Integer.parseInt(reader.readLine());
            list.add(string);
        }
        int[] arr = Arrays
                .stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Box<Integer> stringBox = new Box<>(list);
        stringBox.swap(list, arr[0],arr[1]);

        System.out.println(stringBox.toString());

    }

}
