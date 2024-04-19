package at.ac.uibk.pm.g03.csbb5525.s03.e01;

public enum RamSlots {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4);

    private int slots;
    RamSlots(int slots) {
        this.slots = slots;
    }

    int getRAMSlots(){
        return slots;
    }

}
