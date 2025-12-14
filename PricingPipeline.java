package domain;

import java.math.BigDecimal;
import java.util.List;

public class PricingPipeline {

    private final List<RateModifier> modifiers;

    public PricingPipeline(List<RateModifier> modifiers) {
        this.modifiers = modifiers;
    }

    public BigDecimal apply(BigDecimal baseMonthly) {
        BigDecimal result = baseMonthly;
        for (RateModifier modifier : modifiers) {
            result = modifier.apply(result);
        }
        return result;
    }
}
