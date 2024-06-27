package at.ac.uibk.pm.g03.csbb5525.test3.e03;

import java.util.*;

//implements Machine
public class PhysicalMachine implements Machine{

    private final Set<Process> processSet = new TreeSet<>();

    private double availableMemoryInGb;

    public PhysicalMachine(double availableMemoryInGb) {
        this.availableMemoryInGb = availableMemoryInGb;
    }

    @Override
    public double calculateMemoryUsageInGb() {
        double allProcessMemoryUsage = processSet
                .stream()
                //.map(Process::getCurrentMemoryUsageInGb)  //WRONG here! must use getActualMemoryUsage!!!
                .map(Process::getActualMemoryUsageInGb)
                .reduce(0.0, Double::sum);
        return Double.min(availableMemoryInGb, allProcessMemoryUsage);

    }

    //correct??
    public double calculateMemoryUsageInGb_2(){
        return Math.min(
                availableMemoryInGb, getTotalProcessMemory()
        );
    }



    @Override
    public void addProcess(Process process) {
        if(process == null){
            throw new IllegalArgumentException("process == null");
        }
        boolean added = processSet.add(process);

        if(!added){
            System.out.println("Process " + process + " not added. ");
            //throw new IllegalArgumentException();
        }
    }

    @Override
    public Collection<Process> getProcesses() {
        return new ArrayList<>(processSet);
    }
}
