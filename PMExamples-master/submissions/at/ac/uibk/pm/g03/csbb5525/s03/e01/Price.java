package at.ac.uibk.pm.g03.csbb5525.s03.e01;


import java.util.Random;

public class Price {
    Currency currency;
    private float amount;

    {
        this.currency = Currency.EURO;
    }

    public float getAmount(Currency currency) {
        return switch (currency){
            case EURO -> this.amount;
            case USD -> (this.amount*1.06f);
            case AUD -> (this.amount*1.65f);
            case GBP -> (this.amount*0.85f);
        };

    }

    public Price(float amount){
        this.amount = amount;
    }
    public Price(CPUManufacturer manufacturer, int cores, String model){
        //String model is used as "randomizer" that should always get the same value for the same input.
        int pricePerCore = 15;

        long modelModifier = model.hashCode();
        Random randomPriceFluctuations = new Random(modelModifier);

        float priceFluctuations = (float) (randomPriceFluctuations.nextInt(10000) + 1) /100;

        float price = pricePerCore * cores + priceFluctuations;

        switch (manufacturer){
            case AMD -> this.amount = price;
            case INTEL -> this.amount = price * 1.2f;
        }

    }



}
