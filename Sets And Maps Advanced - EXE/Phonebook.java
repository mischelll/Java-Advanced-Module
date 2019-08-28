package JavaAdvancedExe;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<String, String> nameNumber = new LinkedHashMap<>();

        String command;
        while (!"search".equals(command = in.nextLine())) {
            String[] input = command.split("-");

            String name = input[0];
            String number = input[1];

            nameNumber.put(name, number);


        }

        while (!"stop".equals(command = in.nextLine())){


            if (nameNumber.containsKey(command)){
                System.out.printf("%s -> %s\n",command,nameNumber.get(command));
            }else {
                System.out.printf("Contact %s does not exist.\n",command);
            }


        }
    }
}
