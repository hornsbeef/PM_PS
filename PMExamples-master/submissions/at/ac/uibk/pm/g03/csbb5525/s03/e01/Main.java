package at.ac.uibk.pm.g03.csbb5525.s03.e01;


public class Main {

    public static void main(String[] args){

        Computer pc1 = new Computer(2024, CPUManufacturer.AMD, 16, "AsdFFF",
                                    2000, 1000, "E970", RamSlots.TWO,
                                    16, 4500,"Corsair", GPUManufacturer.AMD,
                                    "XFX7900");


        Currency currency = Currency.EURO;

        System.out.println("This Computer costs " + pc1.getPCPrice(currency) + " " +currency.name());

        pc1.printInfo(currency);

        double dataToTransferGB = 10.765;

        System.out.println("It takes " + pc1.dataTransferDuration(dataToTransferGB) + " seconds to transfer "
                                   + Double.toString(dataToTransferGB) +" GB of data."
                );

    }


}
