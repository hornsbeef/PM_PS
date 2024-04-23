package at.ac.uibk.pm.g03.csbb5525.s03.e01;

public class Processor implements HardwareComponent {
    private final Model model;
    private final CPUManufacturer manufacturer;
    private final int cores;

    public Processor(CPUManufacturer manufacturer, int cores, String model){
        this.model = new Model(manufacturer, cores, model);
        this.manufacturer = manufacturer;
        this.cores = cores;


    }

    public String getCPUModel(){
        return model.getModel();
    }
    public CPUManufacturer getCPUManufacturer(){return manufacturer; }
    public int getCPUCores(){return cores;}


    @Override
    public float getPrice(Currency currency) {
        return PriceCalculator.getAmount(this);
    }
}
