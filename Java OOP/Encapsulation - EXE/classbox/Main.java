package javaoopexe.classbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            double length = Double.parseDouble(reader.readLine());
            double width = Double.parseDouble(reader.readLine());
            double height = Double.parseDouble(reader.readLine());

            Box box = new Box(length, width, height);
            System.out.printf("Surface Area - %.2f%n" +
                            "Lateral Surface Area - %.2f%n" +
                            "Volume – %.2f%n",
                    box.calculateSurfaceArea(),
                    box.calculateLateralSurfaceArea(),
                    box.calculateVolume());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
