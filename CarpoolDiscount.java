package domain;

import java.math.BigDecimal;

public class CarpoolDiscount implements RateModifier {

    @Override
    public BigDecimal apply(BigDecimal currentMonthly) {
        return currentMonthly.multiply(new BigDecimal("0.90"));
    }
}
