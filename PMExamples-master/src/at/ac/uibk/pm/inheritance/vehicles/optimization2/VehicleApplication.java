package at.ac.uibk.pm.inheritance.vehicles.optimization2;

/**
 * Class provides tests of a first approach for inheriting data and methods.
 */

public class VehicleApplication {

    /**
     * Main method for showing inheritance of trucks and vehicles.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("IL 473 NJ", "Technik Campus");
        Truck truck = new Truck("I DRINK 1", "Munich", "juice");
        truck.setCargo("water");
        System.out.println(vehicle.getInfo());
        System.out.println(truck.getInfo());


        System.out.println(truck.getLicensePlate());
        System.out.println(truck.getLocation());


    }

}
