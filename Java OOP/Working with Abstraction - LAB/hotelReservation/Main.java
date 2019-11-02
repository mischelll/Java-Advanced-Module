package javaooplabs.hotelReservation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");
        double price = Double.parseDouble(input[0]);
        int numberOfDays = Integer.parseInt(input[1]);
        Season season = Season.valueOf(input[2]);
        Discount discount = Discount.valueOf(input[3]);

        System.out.printf("%.2f",PriceCalculator.calculatePrice(price,numberOfDays,season,discount));

    }
}
