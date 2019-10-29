package JavaAdvancedExe;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        Set<String> usernames = new LinkedHashSet<>();

        while (n-- > 0){
            String name = in.nextLine();
            usernames.add(name);
        }

        for (String username : usernames) {
            System.out.println(username);
        }
    }
}
