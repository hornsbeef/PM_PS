package at.ac.uibk.pm.g03.csbb5525.s03.e01;

public enum RamSlots {
    ONE,
    TWO,
    THREE,
    FOUR;

    int getRAMSlots(){
        return this.ordinal()+1;
    }

}
