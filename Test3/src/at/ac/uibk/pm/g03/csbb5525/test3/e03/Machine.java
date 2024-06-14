package at.ac.uibk.pm.g03.csbb5525.test3.e03;

import java.util.Collection;

public interface Machine {

    double calculateMemoryUsageInGb();
    void addProcess(Process process);
    Collection<Process> getProcesses();


}
