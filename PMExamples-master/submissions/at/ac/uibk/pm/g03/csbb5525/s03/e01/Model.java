package at.ac.uibk.pm.g03.csbb5525.s03.e01;

public class Model {

    enum Part {PC, CPU, HDD, RAM, GPU;}
    private Part type;
    private String model;


    String getModel(){
        return model;
    }

    //CPU Model:
    public Model(CPUManufacturer manufacturer, int cores, String model){
        this.type = Part.CPU;
        this.model = String.format(this.type.toString() + "-"
                                           + manufacturer.toString() + "-"
                                           + Integer.toString(cores) + "C-"
                                           + model);
    }


    //HDD model:
    public Model(int storageCapacity, int dataWriteRate, String model){
        this.type = Part.HDD;
        this.model = String.format(this.type.toString() + "-"
                                           + Integer.toString(storageCapacity) + "GB"
                                           + "@" +Integer.toString(dataWriteRate) + "MB/s-"
                                           +model);
    }

    //RAM Model
    public Model(String model, int memory, int clockSpeed){
        this.type = Part.RAM;
        this.model = String.format(this.type.toString() + "-"
                                           + Integer.toString(memory) + "GB"
                                           + "@" +Integer.toString(clockSpeed) + "MHz-"
                                           +model);
    }

    //GPU Model
    public Model(GPUManufacturer manufacturer, String model){
        this.type = Part.GPU;
        this.model = String.format(this.type.toString() + "-"
                                           +manufacturer.toString() + "-"
                                           + model);
    }

    //PC Model:
    public Model(int manufacturingYear, Processor processor, HDD hardDisk, RAM[] ramSlots, GPU gpu){
        this.type = Part.PC;
        this.model = String.format(this.type.toString() + "-"
                                           +processor.getCPUModel()+ "-"
                                           +hardDisk.getHDDModel() + "-"
                                           +ramSlots.length +"x["+ramSlots[0].getRAMModel()+"]"+ "-"
                                           +gpu.getGPUModel());

    }

}
