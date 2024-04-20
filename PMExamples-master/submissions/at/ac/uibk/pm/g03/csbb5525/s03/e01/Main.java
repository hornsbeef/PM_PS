package at.ac.uibk.pm.g03.csbb5525.s03.e01;


public class Main {

    public static void main(String[] args){

        Computer pc1 = new Computer(2024, CPUManufacturer.AMD, 16, "AsdFFF",
                                    2000, 1000, "E970", RamSlots.TWO,
                                    16, 4500,"Corsair", GPUManufacturer.AMD,
                                    "XFX7900");


        Currency currency = Currency.EURO;

        System.out.println("This Computer costs " + pc1.getPCPrice(currency) + " " +currency.name());


        //set to true, if ALL info is required:
        boolean getAllInfo = true;

        pc1.printInfo(currency, getAllInfo);

        double dataToTransferGB = 10.765;

        System.out.println("It takes " + pc1.dataTransferDuration(dataToTransferGB) + " seconds to transfer "
                                   + Double.toString(dataToTransferGB) +" GB of data."
                );

        System.out.println("\n\n\n");

        Computer pc2 = new Computer(2018, CPUManufacturer.INTEL, 4, "i3-3978",
                                    2000, 560, "E970", RamSlots.ONE,
                                    8, 2666,"Generic", GPUManufacturer.NVIDIA,
                                    "780Ti");


        System.out.println("This Computer costs " + pc2.getPCPrice(currency) + " " +currency.name());
        pc2.printInfo(currency, getAllInfo);
        System.out.println("It takes " + pc2.dataTransferDuration(dataToTransferGB) + " seconds to transfer "
                                   + Double.toString(dataToTransferGB) +" GB of data.");
    }


}
