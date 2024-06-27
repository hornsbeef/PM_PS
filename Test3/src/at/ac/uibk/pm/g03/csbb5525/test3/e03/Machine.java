package at.ac.uibk.pm.g03.csbb5525.test3.e03;

import java.util.Collection;

public interface Machine {

    double calculateMemoryUsageInGb();
    void addProcess(Process process);
    Collection<Process> getProcesses();


    default double getTotalProcessMemory() {
        //System.out.println(getProcesses());
        //getProcesses().stream().mapToDouble(Process::getActualMemoryUsageInGb).forEach(System.out::println);
        //System.out.println("-".repeat(20));
        //getProcesses().stream().mapToDouble(Process::getCurrentMemoryUsageInGb).forEach(System.out::println);
        return getProcesses().stream().mapToDouble(Process::getActualMemoryUsageInGb).sum();
        //return getProcesses().stream().mapToDouble(Process::getCurrentMemoryUsageInGb).sum();
    }
}
