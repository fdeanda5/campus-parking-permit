package domain;

public final class PermitSelection implements Validatable {

    public final PermitType permitType;
    public final VehicleType vehicleType;
    public final boolean carpool;
    public final int months;

    public PermitSelection(PermitType permitType, VehicleType vehicleType, boolean carpool, int months) {
        this.permitType = permitType;
        this.vehicleType = vehicleType;
        this.carpool = carpool;
        this.months = months;
        validate();
    }

    @Override
    public void validate() {
        if (months < 1 || months > 12) {
            throw new InvalidSelectionException("Months must be between 1 and 12.");
        }
    }
}
