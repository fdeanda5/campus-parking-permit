package domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public final class PricingCalculator {

    public Receipt calculate(PermitSelection selection, PricingStrategy strategy) {
        BigDecimal monthly = strategy.computeMonthly(selection);

        List<RateModifier> modifiers = new ArrayList<>();
        modifiers.add(selection.vehicleType);

        if (selection.carpool) {
            modifiers.add(new CarpoolDiscount());
        }

        PricingPipeline pipeline = new PricingPipeline(modifiers);
        BigDecimal adjustedMonthly = pipeline.apply(monthly);

        BigDecimal subtotal = adjustedMonthly.multiply(BigDecimal.valueOf(selection.months));
        BigDecimal fee = subtotal.multiply(new BigDecimal("0.05"));
        BigDecimal total = subtotal.add(fee);

        return new Receipt(adjustedMonthly, subtotal, fee, total, selection);
    }
}
