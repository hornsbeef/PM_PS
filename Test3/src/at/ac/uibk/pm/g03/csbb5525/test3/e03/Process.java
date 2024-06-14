package at.ac.uibk.pm.g03.csbb5525.test3.e03;

import java.util.Set;
import java.util.TreeSet;

public class Process implements Comparable<Process>{



    private final long processId;
    private double currentMemoryUsageInGb;

    public Process(long processId, double currentMemoryUsageInGb, Machine thisRunsOn) {
        if(thisRunsOn.getProcesses().stream().map(Process::getProcessId).toList().contains(processId)){
            throw new IllegalArgumentException("Process-ID already in use");
        }
        this.processId = processId;
        this.currentMemoryUsageInGb = currentMemoryUsageInGb;
        thisRunsOn.addProcess(this);
    }

    public long getProcessId() {
        return processId;
    }

    public double getCurrentMemoryUsageInGb() {
        return currentMemoryUsageInGb;
    }

    public double getActualMemoryUsageInGb(){
        return currentMemoryUsageInGb;
    }

    @Override
    public int compareTo(Process o) {
        int idComparison = Long.compare(this.processId, o.getProcessId());
        int memCoparison = Double.compare(this.currentMemoryUsageInGb, o.getCurrentMemoryUsageInGb());
        if(idComparison != 0){
            return idComparison;
        }
        return memCoparison;
    }

    @Override
    public String toString() {
        return "Process{" +
                "processId=" + processId +
                '}';
    }
}
