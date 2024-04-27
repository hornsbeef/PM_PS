package at.ac.uibk.pm.g03.csbb5525.s03.e01;


import java.util.Random;


public class PriceCalculator {

    public static float getAmount(Currency currency, float baseAmount) {
        return switch (currency){
            case EURO -> baseAmount;
            case USD -> (baseAmount*1.06f);
            case AUD -> (baseAmount*1.65f);
            case GBP -> (baseAmount*0.85f);
        };

    }

    public static float getAmount(Processor cpu){
        int pricePerCore = 15;

        long modelModifier = cpu.getCPUModel().hashCode();
        Random randomPriceFluctuations = new Random(modelModifier);

        float priceFluctuations = (float) (randomPriceFluctuations.nextInt(10000) + 1) /100;

        float price = pricePerCore * cpu.getCPUCores() + priceFluctuations;

        return switch (cpu.getCPUManufacturer()){
            case INTEL ->  price * 1.2f;
            case AMD -> price;
        };
    }

    public PriceCalculator(CPUManufacturer manufacturer, int cores, String model){
        //String model is used as "randomizer" that should always get the same value for the same input.


    }



}
