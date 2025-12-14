package domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Receipt {

    private final BigDecimal monthly, subtotal, fee, total;
    private final PermitSelection selection;

    public Receipt(BigDecimal monthly, BigDecimal subtotal, BigDecimal fee,
                   BigDecimal total, PermitSelection selection) {
        this.monthly = monthly;
        this.subtotal = subtotal;
        this.fee = fee;
        this.total = total;
        this.selection = selection;
    }

    public void print() {
        System.out.println("\n=== Campus Parking Receipt ===");
        System.out.println("Permit Type: " + selection.permitType);
        System.out.println("Vehicle Type: " + selection.vehicleType);
        System.out.println("Carpool: " + (selection.carpool ? "Yes" : "No"));
        System.out.println("Months: " + selection.months);
        System.out.println("Monthly Rate: $" + monthly.setScale(2, RoundingMode.HALF_UP));
        System.out.println("Subtotal: $" + subtotal.setScale(2, RoundingMode.HALF_UP));
        System.out.println("Campus Fee (5%): $" + fee.setScale(2, RoundingMode.HALF_UP));
        System.out.println("TOTAL: $" + total.setScale(2, RoundingMode.HALF_UP));
    }
}
