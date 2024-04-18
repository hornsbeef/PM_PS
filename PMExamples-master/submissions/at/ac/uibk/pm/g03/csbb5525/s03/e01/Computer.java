package at.ac.uibk.pm.g03.csbb5525.s03.e01;

import java.text.DecimalFormat;

public class Computer {

    private Model pcModel;
    private int manufacturingYear;
    private Processor processor;
    private HDD hardDisk;
    private RAM[] ramSlots;
    private GPU gpu;

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



    }
    DecimalFormat currencyFormatter = new DecimalFormat("0.00");
    String getPCPrice(Currency currency){

        float sum = processor.getCPUPrice(currency)
                + hardDisk.getHDDPrice(currency)
                + (ramSlots.length * ramSlots[0].getRAMPrice(currency)
                + gpu.getGPUPrice(currency)
                );



        return currencyFormatter.format(sum);

    }

    void printInfo(Currency currency){   //Printing all the details summarized via model:
        System.out.println("Computer's detail:\n"
                +"Model: " + pcModel.getModel() + "\n"
                +"Manufacturing Year: " + manufacturingYear + "\n"
                +"Computer Price: " + getPCPrice(currency) + " " +currency.name()+ "\n"

                +"Processor Model: " + processor.getCPUModel() + "\n"
                +"Processor Price: " + currencyFormatter.format(processor.getCPUPrice(currency)) + " " +currency.name()+ "\n"

                +"Hard Disk Model: " + hardDisk.getHDDModel() + "\n"
                +"Hard Disk Price: " + currencyFormatter.format(hardDisk.getHDDPrice(currency)) + " " +currency.name()+ "\n"

                +"Ram Slots: " + ramSlots.length+ "\n"
                +"Ram Model: " + ramSlots[0].getRAMModel() + "\n"
                +"Ram Price per module: " + currencyFormatter.format(ramSlots[0].getRAMPrice(currency)) + " " +currency.name()+ "\n"

                +"GPU Model: " + gpu.getGPUModel() + "\n"
                +"GPU Price: " + currencyFormatter.format(gpu.getGPUPrice(currency))+ " " +currency.name()+ "\n"
        );
    }

    double dataTransferDuration(double sizeGB){
        return hardDisk.hddDataTransferDuration(sizeGB);
    }



}
