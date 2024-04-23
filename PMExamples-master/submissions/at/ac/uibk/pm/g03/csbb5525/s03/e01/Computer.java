package at.ac.uibk.pm.g03.csbb5525.s03.e01;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final Model pcModel;
    private final int manufacturingYear;
    private final Processor processor;
    private final HDD hardDisk;
    private final RAM[] ramSlots;
    private final GPU gpu;

    public Computer(int manufacturingYear, CPUManufacturer cpuManufacturer, int cores, String cpuModel,
                    int hddStorageCapacity, int hddDataWriteRate, String hddModel,
                    RamSlots ramModulCount, int ramMemory, int ramClockSpeed, String ramModel,
                    GPUManufacturer gpuManufacturer, String gpuModel){
        //todo: do checks for useful/sane input!
        this.manufacturingYear = manufacturingYear;
        this.processor = new Processor(cpuManufacturer, cores, cpuModel);
        this.hardDisk = new HDD(hddStorageCapacity, hddDataWriteRate, hddModel);
        this.ramSlots = new RAM[ramModulCount.getRAMSlots()];
        for (int i = 0; i < this.ramSlots.length; i++) {
            this.ramSlots[i] = new RAM(ramMemory, ramClockSpeed, ramModel);
        }
        this.gpu = new GPU(gpuManufacturer, gpuModel);

        this.pcModel = new Model(manufacturingYear, this.processor, this.hardDisk, this.ramSlots, this.gpu);

        List<HardwareComponent> components = new ArrayList<>();
        components.add(processor);
        components.add(hardDisk);

        float totalSum = 0;
        for (var component : components){
            totalSum += component.getPrice(Currency.EURO);
        }



    }



    DecimalFormat currencyFormatter = new DecimalFormat("0.00");
    String getPCPrice(Currency currency){

        float sum = processor.getPrice(currency)
                + hardDisk.getPrice(currency)
                + (ramSlots.length * ramSlots[0].getPrice(currency)
                + gpu.getPrice(currency)
                );



        return currencyFormatter.format(sum);

    }

    void printInfo(Currency currency){   //Printing all the details summarized via model:
        System.out.println("Computer's detail:\n"
                +"Model: " + pcModel.getModel() + "\n"
                +"Manufacturing Year: " + manufacturingYear + "\n"
                +"Computer Price: " + getPCPrice(currency) + " " +currency.name()+ "\n"

                +"Processor Model: " + processor.getCPUModel() + "\n"
                +"Processor Price: " + currencyFormatter.format(processor.getPrice(currency)) + " " +currency.name()+ "\n"

                +"Hard Disk Model: " + hardDisk.getHDDModel() + "\n"
                +"Hard Disk Price: " + currencyFormatter.format(hardDisk.getPrice(currency)) + " " +currency.name()+ "\n"

                +"Ram Slots: " + ramSlots.length+ "\n"
                +"Ram Model: " + ramSlots[0].getRAMModel() + "\n"
                +"Ram Price per module: " + currencyFormatter.format(ramSlots[0].getPrice(currency)) + " " +currency.name()+ "\n"

                +"GPU Model: " + gpu.getGPUModel() + "\n"
                +"GPU Price: " + currencyFormatter.format(gpu.getPrice(currency))+ " " +currency.name()+ "\n"
        );
    }

    void printInfo(Currency currency, boolean printAllInfo){
        if(!printAllInfo){
            printInfo(currency);
            return;
        }

        System.out.println("Computer's detail:\n"
                                   +"Model: " + pcModel.getModel() + "\n"
                                   +"Manufacturing Year: " + manufacturingYear + "\n"
                                   +"Computer Price: " + getPCPrice(currency) + " " +currency.name()+ "\n"


                                   +"Processor Model: " + processor.getCPUModel() + "\n"
                                   +"Processor Price: " + currencyFormatter.format(processor.getPrice(currency)) + " " +currency.name()+ "\n"
                                   +"Processor Manufacturer: " + processor.getCPUManufacturer() + "\n"
                                   +"Processor Cores: " + processor.getCPUCores() + "\n"


                                   +"Hard Disk Model: " + hardDisk.getHDDModel() + "\n"
                                   +"Hard Disk Price: " + currencyFormatter.format(hardDisk.getPrice(currency)) + " " +currency.name()+ "\n"
                                   +"Hard Disk Storage Capacity: " + hardDisk.getStorageCapacity() + "\n"
                                   +"Hard Disk Data Write Rate: " + hardDisk.getDataWriteRate() + "\n"


                                   +"Ram Model: " + ramSlots[0].getRAMModel() + "\n"
                                   +"Ram Price per module: " + currencyFormatter.format(ramSlots[0].getPrice(currency)) + " " +currency.name()+ "\n"
                                   +"Ram Slots: " + ramSlots.length+ "\n"
                                   +"Ram Memory per Slot: " + ramSlots[0].getMemory() + "\n"
                                   +"Ram Clockspeed: " + ramSlots[0].getClockSpeedInMhz() + "\n"

                                   +"GPU Model: " + gpu.getGPUModel() + "\n"
                                   +"GPU Price: " + currencyFormatter.format(gpu.getPrice(currency))+ " " +currency.name()+ "\n"
                                   +"GPU Manufacturer: " + gpu.getGPUManufacturer() + "\n"
        );




    }

    double dataTransferDuration(double sizeGB){
        return hardDisk.hddDataTransferDuration(sizeGB);
    }



}
