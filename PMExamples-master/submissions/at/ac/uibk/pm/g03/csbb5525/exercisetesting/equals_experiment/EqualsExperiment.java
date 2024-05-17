package at.ac.uibk.pm.g03.csbb5525.exercisetesting.equals_experiment;

import java.util.Objects;

public class EqualsExperiment implements Cloneable{
    private String test;
    private int i = 3;

    public EqualsExperiment(String string){
        this.test = string;
    }

    //Copy constructor
    public EqualsExperiment(EqualsExperiment other){
        this.test = other.test;
        this.i = other.i;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EqualsExperiment that)) return false;
        return i == that.i && Objects.equals(test, that.test);
    }


    @Override
    public int hashCode() {
        //return Objects.hashCode(test);    //normal way

        final int prime = 31;
        int result;

        if(this.test == null){
            result = 0;
        }
        else{
            result = test.hashCode();
        }
        result = (prime*result) + Integer.hashCode(i);
        return result;

    }

    @Override
    public EqualsExperiment clone()
    {
        try{
            return (EqualsExperiment)super.clone();//throws CloneNotSupportedException
        }catch(CloneNotSupportedException cnsE){
            throw new RuntimeException("Clone not successful");
        }

    }
}
