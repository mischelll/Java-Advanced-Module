package JavaAdvancedExe.genericSwapMethodString;

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
        List<String> list = new ArrayList<>();
        while (n-- > 0) {
            String string = reader.readLine();
            list.add(string);
        }
        int[] arr = Arrays
                .stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Box<String> stringBox = new Box<>(list);
        stringBox.swap(list, arr[0],arr[1]);

        System.out.println(stringBox.toString());

    }
}
