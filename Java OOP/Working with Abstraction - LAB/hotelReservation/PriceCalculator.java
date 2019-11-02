package javaooplabs.hotelReservation;

public class PriceCalculator {
    public static double calculatePrice(double pricePerDay, int numberOfDays, Season season, Discount discount){
        int multiplier = season.getValue();
        double discountMultiplier = discount.getValue() / 100.00;
        double totalPrice = numberOfDays * pricePerDay * multiplier;
        double discountedAmount = totalPrice * discountMultiplier;

        return totalPrice - discountedAmount;
    }

}
