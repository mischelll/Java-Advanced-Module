package javaoopexe.harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Class reflectionClass = RichSoilLand.class;
        Field[] fields = reflectionClass.getDeclaredFields();

        String format = "%s %s %s";

        String input = "";
        while (!"HARVEST".equals(input = reader.readLine())) {
            String access = "";
            switch (input) {
                case "private":
                    access = "private";
                    break;
                case "public":
                    access = "public";
                    break;
                case "protected":
                    access = "protected";
                    break;
                case "all":
                    Arrays.stream(fields)
                            .forEach(e -> System.out.println(Modifier.toString(e.getModifiers()) +
                            " " + e.getType().getSimpleName() +
                            " " + e.getName()));
                    break;
            }
            String finalAccess = access;
            Arrays.stream(fields)
                    .filter(e -> Modifier.toString(e.getModifiers()).equals(finalAccess))
                    .forEach(e -> System.out.println(String.format(format
                            , finalAccess
                            , e.getType().getSimpleName()
                            , e.getName())));
        }

    }
}
