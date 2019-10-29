package JavaAdvancedExe;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FixEmails {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<String, String> userEmail = new LinkedHashMap<>();
        String regex = "\\.([\\w]+)";
        Pattern pattern = Pattern.compile(regex);

        String command;
        while (!"stop".equals(command = in.nextLine())) {
            String name = command;
            String email = in.nextLine();

            Matcher matcher = pattern.matcher(email);
            if (matcher.find()) {
                String ending = matcher.group();

                if (!ending.equals(".us") && !ending.equals(".uk") && !ending.equals(".com")) {
                    userEmail.put(name, email);
                }
            }
        }

        userEmail.entrySet().stream().forEach(e -> System.out.printf("%s -> %s\n",e.getKey(),e.getValue()));
    }
}
