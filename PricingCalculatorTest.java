import domain.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class PricingCalculatorTest {

    @Test
    void residentCarNoCarpool() {
        PermitSelection sel = new PermitSelection(PermitType.RESIDENT, VehicleType.CAR, false, 1);
        PricingCalculator calc = new PricingCalculator();
        Receipt receipt = calc.calculate(sel, new ResidentPricingStrategy());
        assertNotNull(receipt);
    }

    @Test
    void commuterStrategyPolymorphism() {
        PricingStrategy strategy = new CommuterPricingStrategy();
        PermitSelection sel = new PermitSelection(PermitType.COMMUTER, VehicleType.CAR, false, 1);
        BigDecimal monthly = strategy.computeMonthly(sel);
        assertEquals(new BigDecimal("29.75"), monthly);
    }

    @Test
    void vehicleModifierPolymorphism() {
        RateModifier suv = VehicleType.SUV;
        BigDecimal result = suv.apply(new BigDecimal("100"));
        assertEquals(new BigDecimal("115.00"), result);
    }

    @Test
    void carpoolDiscountApplied() {
        RateModifier carpool = new CarpoolDiscount();
        BigDecimal result = carpool.apply(new BigDecimal("100"));
        assertEquals(new BigDecimal("90.00"), result);
    }

    @Test
    void invalidMonthsThrowsException() {
        assertThrows(InvalidSelectionException.class,
                () -> new PermitSelection(PermitType.RESIDENT, VehicleType.CAR, false, 15));
    }
}
