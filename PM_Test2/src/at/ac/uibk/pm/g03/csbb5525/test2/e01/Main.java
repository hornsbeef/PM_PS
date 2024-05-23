package at.ac.uibk.pm.g03.csbb5525.test2.e01;public class Main {

    public static void main(String[] args) {
        RentalSystem rentalSystem = new RentalSystem();

        Vehicle vehicle2 = new Vehicle("ID2");
        Vehicle vehicle1 = new Vehicle("ID1");
        rentalSystem.addVehicle(vehicle2);
        rentalSystem.addVehicle(vehicle1);

        try{
            rentalSystem.rentVehicle("ID1");

        }catch(VehicleRentedException vre){
            System.out.println("The vehicle is already rented.");
        }catch(VehicleNotFoundException vnfe){
            System.out.println("The requested Vehicle is not part of the fleet");
        }

        //testing
        System.out.println(vehicle1.getStatus());
        System.out.println(vehicle2.getStatus());

        try{
            rentalSystem.returnVehicle("ID1");
        }catch(VehicleNotRentedException vnre){
            System.out.println("The vehicle is not rented.");
        }catch(VehicleNotFoundException vnfe){
            System.out.println("The requested Vehicle is not part of the fleet");
        }

        System.out.println(vehicle1.getStatus());
        System.out.println(vehicle2.getStatus());

        try{
            rentalSystem.returnVehicle("IDnonExistant");
        }catch(VehicleNotRentedException vnre){
            System.out.println("The vehicle is not rented.");
        }catch(VehicleNotFoundException vnfe){
            System.out.println("The requested Vehicle is not part of the fleet");
        }


    }

}
