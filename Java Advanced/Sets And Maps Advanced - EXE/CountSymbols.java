package JavaAdvancedExe;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        char[] arr = input.toCharArray();
        Map<Character, Integer> symbols = new TreeMap<>();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            symbols.putIfAbsent(c, 0);
            symbols.put(c,symbols.get(c) + 1);
        }

        symbols.entrySet().stream().forEach(e -> System.out.printf("%c: %d time/s\n",e.getKey(),e.getValue()));

    }
}
