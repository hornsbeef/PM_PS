package at.ac.uibk.pm.g03.csbb5525.s03.e01;

public class GPU implements HardwareComponent {
    private final Model model;
    private final GPUManufacturer manufacturer;

    public GPU(GPUManufacturer manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = new Model(this.manufacturer, model);
    }

    String getGPUModel() {
        return model.getModel();
    }

    public GPUManufacturer getGPUManufacturer() {
        return manufacturer;
    }

    @Override
    public float getPrice(Currency currency) {
        float price = 800;
        return PriceCalculator.getAmount(currency, getBaseAmount(price));
    }

    private float getBaseAmount(float price) {
        return switch (manufacturer) {
            case INTEL -> price * 0.8f;
            case NVIDIA -> price * 1.2f;
            case AMD -> price;
        };
    }


}
