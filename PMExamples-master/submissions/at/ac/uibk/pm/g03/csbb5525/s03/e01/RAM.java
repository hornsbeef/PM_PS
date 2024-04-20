package at.ac.uibk.pm.g03.csbb5525.s03.e01;

public class RAM {
    private Model model;
    private int memory; //in GB
    private int clockSpeed;  //in MHz
    private Price price;


    public RAM(int memory, int clockSpeed, String model){
        this.memory = memory;
        this.clockSpeed = clockSpeed;
        this.model = new Model(model, memory, clockSpeed);
        if(clockSpeed > 3600){
            this.price = new Price(memory * 5f);
        }else{
            this.price = new Price(memory * 2.1f);
        }
    }

    String getRAMModel(){
        return model.getModel();
    }

    float getRAMPrice(Currency currency){
        return price.getAmount(currency);
    }

    int getMemory() {
        return memory;
    }

    int getClockSpeed() {
        return clockSpeed;
    }
}
