import domain.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Permit type (RESIDENT/COMMUTER): ");
            PermitType permit = PermitType.valueOf(sc.nextLine().toUpperCase());

            System.out.print("Vehicle type (CAR/SUV/MOTORCYCLE): ");
            VehicleType vehicle = VehicleType.valueOf(sc.nextLine().toUpperCase());

            System.out.print("Carpool? (Y/N): ");
            boolean carpool = sc.nextLine().equalsIgnoreCase("Y");

            System.out.print("Months (1-12): ");
            int months = Integer.parseInt(sc.nextLine());

            PermitSelection selection = new PermitSelection(permit, vehicle, carpool, months);

            PricingStrategy strategy =
                    permit == PermitType.RESIDENT
                            ? new ResidentPricingStrategy()
                            : new CommuterPricingStrategy();

            PricingCalculator calculator = new PricingCalculator();
            Receipt receipt = calculator.calculate(selection, strategy);
            receipt.print();

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
