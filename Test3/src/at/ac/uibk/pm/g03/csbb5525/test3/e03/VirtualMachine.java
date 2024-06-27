package at.ac.uibk.pm.g03.csbb5525.test3.e03;

import java.util.*;

//implements Machine
public class VirtualMachine extends Process implements Machine {

    private final Set<Process> processSet = new TreeSet<>();

    private double availableMemoryInGb;
    private double memoryUsage;
    private final Machine physicalMachineThisVMisRunningOn;

    public VirtualMachine(long processId, double currentMemoryUsageInGb, double availableMemoryInGb, Machine physicalMachine) {
        super(processId, currentMemoryUsageInGb, physicalMachine);
        this.memoryUsage = currentMemoryUsageInGb;
        this.availableMemoryInGb = availableMemoryInGb;
        this.physicalMachineThisVMisRunningOn = physicalMachine;
        physicalMachine.addProcess(this);

    }


    @Override
    public double calculateMemoryUsageInGb() {
        double other = processSet.stream().map(Process::getCurrentMemoryUsageInGb).reduce(0.0, Double::sum);
        double all = other + memoryUsage;
        return Double.min(availableMemoryInGb, all);

    }

    @Override
    public void addProcess(Process process) {
        if(process == null){
            throw new IllegalArgumentException("process == null");
        }
        this.processSet.add(process);
    }

    @Override
    public Collection<Process> getProcesses() {
        return new ArrayList<>(processSet);
    }

    @Override
    public double getActualMemoryUsageInGb(){
        double other = processSet.stream().map(Process::getCurrentMemoryUsageInGb).reduce(0.0, Double::sum);
        double all = other + memoryUsage;
        return Double.min(availableMemoryInGb, all);
    }

    //@Override //this one correct??
    public double getActualMemoryUsageInGb2(){
        return Math.min(
                availableMemoryInGb,
                super.getActualMemoryUsageInGb() + getTotalProcessMemory()
        );
    }
}
