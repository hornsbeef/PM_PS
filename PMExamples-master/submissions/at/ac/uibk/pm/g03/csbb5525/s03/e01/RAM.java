package at.ac.uibk.pm.g03.csbb5525.s03.e01;

public class RAM implements HardwareComponent{
    private final Model model;
    private final int memoryInGb;
    private final int clockSpeedInMhz;  //in MHz


    public RAM(int memory, int clockSpeed, String model){
        this.memoryInGb = memory;
        this.clockSpeedInMhz = clockSpeed;
        this.model = new Model(model, memory, clockSpeed);

    }

    String getRAMModel(){
        return model.getModel();
    }
    int getMemory() {
        return memoryInGb;
    }

    int getClockSpeedInMhz() {
        return clockSpeedInMhz;
    }


    @Override
    public float getPrice(Currency currency) {
        return PriceCalculator.getAmount(currency, clockSpeedInMhz > 3600 ? memoryInGb * 5f : 2.1f);
    }
}
