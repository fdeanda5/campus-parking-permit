package domain;

import java.math.BigDecimal;

public class CommuterPricingStrategy implements PricingStrategy {

    @Override
    public BigDecimal computeMonthly(PermitSelection selection) {
        BigDecimal base = new BigDecimal("35.00");
        return base.multiply(new BigDecimal("0.85")); // 15% discount
    }
}
