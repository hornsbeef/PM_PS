package at.ac.uibk.pm.g03.csbb5525.test2.e01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RentalSystem {

    private final List<Vehicle> vehicleFleet = new ArrayList<>();

    private final Map<String, Vehicle> mapVehicleFleet = new HashMap<>();


    public RentalSystem(){
    }

    public void addVehicle(Vehicle vehicle) {
        //maybe check for vehicle == null ? no exception specified

        vehicleFleet.add(vehicle);

        mapVehicleFleet.put(vehicle.getVehicleID(), vehicle);

    }

//    public void rentVehicle(String vehicleID) throws VehicleRentedException, VehicleNotFoundException {
//
//        Vehicle vehicleToRent;
//
//        for(Vehicle vehicle : vehicleFleet){
//
//            if(vehicle.getVehicleID().equals(vehicleID)){
//                vehicleToRent = vehicle;
//
//                if(vehicleToRent.getStatus() == VehicleStatus.RENTED){
//                    throw new VehicleRentedException();
//                }
//                vehicleToRent.setStatus(VehicleStatus.RENTED);
//                return;
//            }
//
//        }
//        throw new VehicleNotFoundException();
//
//    }


    //Time... implement with map -> better !
    public void rentVehicle(String vehicleID) throws VehicleNotFoundException, VehicleRentedException {

        if(!mapVehicleFleet.containsKey(vehicleID)){
            throw new VehicleNotFoundException();
        }

        Vehicle vehicleToRent = mapVehicleFleet.get(vehicleID);

        if(vehicleToRent.getStatus() == VehicleStatus.RENTED){
            throw new VehicleRentedException();
        }
        vehicleToRent.setStatus(VehicleStatus.RENTED);

    }



//    public void returnVehicle(String vehicleID) throws VehicleNotRentedException, VehicleNotFoundException {
//
//        Vehicle vehicleToReturn;
//
//        for(Vehicle vehicle : vehicleFleet){
//            if(vehicle.getVehicleID().equals(vehicleID)){
//                vehicleToReturn = vehicle;
//
//                if(vehicleToReturn.getStatus() == VehicleStatus.AVAILABLE){
//                    throw new VehicleNotRentedException();
//                }
//
//                vehicleToReturn.setStatus(VehicleStatus.AVAILABLE);
//                return;
//            }
//
//        }
//        throw new VehicleNotFoundException();
//
//    }

    public void returnVehicle(String vehicleID) throws VehicleNotFoundException, VehicleNotRentedException {

        if(!mapVehicleFleet.containsKey(vehicleID)){
            throw new VehicleNotFoundException();
        }

        Vehicle vehicleToReturn = mapVehicleFleet.get(vehicleID);

        if(vehicleToReturn.getStatus() == VehicleStatus.AVAILABLE){
            throw new VehicleNotRentedException();
        }

        vehicleToReturn.setStatus(VehicleStatus.AVAILABLE);




    }








}

