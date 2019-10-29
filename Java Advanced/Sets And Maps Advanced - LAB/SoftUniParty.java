package JavaAdvancedLabs;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Set<String> guests = new TreeSet<>();
        Set<String> vip = new TreeSet<>();

        String input;
        while (!"PARTY".equals(input = in.nextLine())) {
            if (Character.isDigit(input.charAt(0)) && input.length() == 8) {
                vip.add(input);

            } else if (input.length() == 8){
                guests.add(input);
            }
        }

        String input2;
        while (!"END".equals(input2 = in.nextLine())) {
            if (vip.contains(input2)) {
                vip.remove(input2);
            }
            if (guests.contains(input2)) {
                guests.remove(input2);
            }

        }

        System.out.println(vip.size() + guests.size());

        if (!vip.isEmpty()){
            for (String s : vip) {
                System.out.println(s);
            }
        }

        if (!guests.isEmpty()){
            for (String guest : guests) {
                System.out.println(guest);
            }
        }

    }
}
