package at.ac.uibk.pm.g03.csbb5525.s03.e01;

public class GPU {
    private Model model;
    private GPUManufacturer manufacturer;
    private Price price;

    public float getGPUPrice(Currency currency) {
        return price.getAmount(currency);
    }

    public GPU(GPUManufacturer manufacturer, String model){
        this.manufacturer = manufacturer;
        this.model = new Model(this.manufacturer, model);
        float price = 800;
        switch(manufacturer){
            case AMD -> this.price = new Price(price);
            case INTEL -> this.price = new Price(price* 0.8f);
            case NVIDIA -> this.price = new Price(price * 1.2f);
        }

    }

    String getGPUModel(){
        return model.getModel();
    }

}
