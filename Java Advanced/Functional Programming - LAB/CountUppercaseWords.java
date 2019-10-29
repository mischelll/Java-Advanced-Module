package JavaAdvancedLabs;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] split = in.nextLine().split(" ");

        Predicate<String> isUpperCase = word -> Character.isAlphabetic(word.charAt(0)) ? Character.isUpperCase(word.charAt(0)) :
                 Character.isUpperCase(word.charAt(1));

        List<String> upperCase = Arrays.stream(split)
                .filter(isUpperCase)
                .collect(Collectors.toList());

        System.out.println(upperCase.size());
        upperCase.forEach(System.out::println);

    }
}
