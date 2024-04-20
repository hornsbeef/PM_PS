package at.ac.uibk.pm.g03.csbb5525.s03.e01;

public class HDD {
    private Model model;
    private int storageCapacity;
    private int dataWriteRate;  //in MB/s
    private Price price;

    public HDD(int storageCapacity, int dataWriteRate, String model){
        this.storageCapacity = storageCapacity;
        this.dataWriteRate = dataWriteRate;
        this.model = new Model(this.storageCapacity, dataWriteRate, model);

        if(dataWriteRate > 800){
            this.price = new Price(storageCapacity * 0.06f);
        }else{
            this.price = new Price(storageCapacity * 0.01f);
        }

    }

    String getHDDModel(){
        return model.getModel();
    }

    float getHDDPrice(Currency currency){
        return price.getAmount(currency);
    }

    int getStorageCapacity() {
        return storageCapacity;
    }

    int getDataWriteRate() {
        return dataWriteRate;
    }

    double hddDataTransferDuration(double sizeGB){

        return sizeGB / ((double) this.dataWriteRate / 1024);

    }


}
