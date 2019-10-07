package JavaAdvancedExe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TPRF {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList());

        List<String> commands = new LinkedList<>();

        String input = reader.readLine();
        while (!"Print".equals(input)) {
            String[] data = input.split(";");
            if (data[0].startsWith("Add")) {
                commands.add(data[1] + ";" + data[2]);
            } else {
                if (commands.contains(data[1] + ";" + data[2])) {
                    commands.remove(data[1] + ";" + data[2]);
                }
            }

            input = reader.readLine();
        }

        for (String command : commands) {
            String[] data = command.split(";");
            String type = data[0];
            String parameter = data[1];

            names.removeIf(getPredicate(type,parameter));
        }

        System.out.println(String.join(" ",names));

    }

    static Predicate<String> getPredicate(String type, String parameter) {
        if (type.equals("Starts with")) {
            return x -> x.startsWith(parameter);
        } else if (type.equals("Ends with")) {
            return x -> x.endsWith(parameter);
        } else if (type.equals("Length")) {
            return x -> x.length() == Integer.parseInt(parameter);
        } else {
            return x -> x.contains(parameter);
        }
    }
}
