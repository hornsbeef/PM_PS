package at.ac.uibk.pm.g03.csbb5525.s03.e01;

public class Processor {
    private Model model;
    private CPUManufacturer manufacturer;
    private int cores;
    private Price price;

    public Processor(CPUManufacturer manufacturer, int cores, String model){
        this.model = new Model(manufacturer, cores, model);
        this.manufacturer = manufacturer;
        this.cores = cores;
        this.price = new Price(manufacturer, cores, model);

    }

    String getCPUModel(){
        return model.getModel();
    }
    String getCPUManufacturer(){return manufacturer.toString(); }
    int getCPUCores(){return cores;}

    float getCPUPrice(Currency currency){
        return price.getAmount(currency);
    }



}
