package JavaAdvancedExe.genericCountMethodString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<String> list = new ArrayList<>();
        while (n-- > 0) {
            String s = reader.readLine();
            list.add(s);

        }

        String element = reader.readLine();
        Box<String> stringBox = new Box<>(list);
        System.out.println(stringBox.getCount(list,element));
    }
}
