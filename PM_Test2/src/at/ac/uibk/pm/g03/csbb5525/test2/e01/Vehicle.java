package at.ac.uibk.pm.g03.csbb5525.test2.e01;

import java.util.Objects;

public class Vehicle {
    private final String vehicleID;
    private VehicleStatus status;

    public Vehicle(String vehicleID) {
        //check that vehicleID is eindeutig
        this.vehicleID = vehicleID;
        this.status = VehicleStatus.AVAILABLE;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }


    //Status is not ?? relevant for equals?

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle vehicle)) return false;
        return Objects.equals(vehicleID, vehicle.vehicleID);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(vehicleID);
    }
}
