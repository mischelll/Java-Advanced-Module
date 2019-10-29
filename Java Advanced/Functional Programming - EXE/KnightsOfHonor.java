package JavaAdvancedExe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Consumer<String> addSir = line -> System.out.printf("Sir %s%n",line);

        Arrays.stream(bf.readLine().split("\\s+")).forEach(addSir);
    }
}
