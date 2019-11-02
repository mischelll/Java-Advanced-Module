package javaooplabs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RhombusOfStars {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= size; i++) {
            printRow(i, size);
        }

        for (int i = size - 1; i >= 0; i--) {
            printRow(i, size);
        }

    }

    static void printRow(int index, int size) {
        printSpaces(index, size);
        printStars(index);
        System.out.println();
    }

    static void printStars(int index) {
        for (int i = 0; i < index; i++) {
            System.out.print("* ");
        }

    }

    static void printSpaces(int index, int size) {
        int leadingSpaces = Math.abs(size - index);
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < leadingSpaces; i++) {
            stringBuilder.append(' ');
        }

        System.out.print(stringBuilder.toString());
    }
}
