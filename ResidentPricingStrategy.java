package domain;

import java.math.BigDecimal;

public class ResidentPricingStrategy implements PricingStrategy {

    @Override
    public BigDecimal computeMonthly(PermitSelection selection) {
        return new BigDecimal("45.00");
    }
}
