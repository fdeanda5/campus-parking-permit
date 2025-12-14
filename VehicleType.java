package domain;

import java.math.BigDecimal;

public enum VehicleType implements RateModifier {
    CAR(BigDecimal.ONE),
    SUV(new BigDecimal("1.15")),
    MOTORCYCLE(new BigDecimal("0.70"));

    private final BigDecimal multiplier;

    VehicleType(BigDecimal multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public BigDecimal apply(BigDecimal currentMonthly) {
        return currentMonthly.multiply(multiplier);
    }
}
