package motocrossWorldChampionship.entities;

import motocrossWorldChampionship.common.ExceptionMessages;

public class PowerMotorcycle extends MotorcycleImpl {
    private static final double CUBIC_CENTIMETERS = 450;
    private static final int MIN_HORSEPOWER = 70;
    private static final int MAX_HORSEPOWER = 100;

    public PowerMotorcycle(String model, int horsePower) {
        super(model, horsePower, CUBIC_CENTIMETERS);
    }

    @Override
    protected void setHorsePower(int horsePower) {
        if (horsePower < MIN_HORSEPOWER || horsePower > MAX_HORSEPOWER) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER, horsePower));
        }
        super.setHorsePower(horsePower);
    }


}
