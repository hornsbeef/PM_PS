package at.ac.uibk.pm.g03.csbb5525.s03.e01;

public class HDD implements HardwareComponent {
    private final Model model;
    private final int storageCapacity;
    private final int dataWriteRate;  //in MB/s

    public HDD(int storageCapacity, int dataWriteRate, String model) {
        this.storageCapacity = storageCapacity;
        this.dataWriteRate = dataWriteRate;
        this.model = new Model(this.storageCapacity, dataWriteRate, model);


    }

    String getHDDModel() {
        return model.getModel();
    }


    int getStorageCapacity() {
        return storageCapacity;
    }

    int getDataWriteRate() {
        return dataWriteRate;
    }

    double hddDataTransferDuration(double sizeGB) {

        return sizeGB / ((double) this.dataWriteRate / 1024);

    }


    @Override
    public float getPrice(Currency currency) {
        return PriceCalculator.getAmount(currency, (dataWriteRate > 800) ? storageCapacity * 0.06f : storageCapacity * 0.01f);
    }
}
