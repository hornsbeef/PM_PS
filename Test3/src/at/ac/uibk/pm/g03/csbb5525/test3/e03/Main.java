package at.ac.uibk.pm.g03.csbb5525.test3.e03;

public class Main {

    public static void main(String[] args) {
        Machine physicalMachine = new PhysicalMachine(32);
        Machine vm = new VirtualMachine(123, 3, 12, physicalMachine);
        Machine vm2 = new VirtualMachine(22, 2, 5, physicalMachine);
        Machine vm3 = new VirtualMachine(13, 1, 2, physicalMachine);
        physicalMachine.addProcess(new Process(21, 12, physicalMachine));

        vm.addProcess(new Process(1233, 4, vm));
        vm2.addProcess(new Process(1233, 4, vm2));
        vm3.addProcess(new Process(1233, 4, vm3));

        Machine ph2 = new PhysicalMachine(12);
        //ph2.addProcess(new Process(123, 2));

        System.out.println("physicalMachine: "+physicalMachine.getProcesses());
        System.out.println("VM: "+ vm.getProcesses());
        System.out.println("VM2: "+ vm2.getProcesses());
        System.out.println("VM3: "+ vm3.getProcesses());
    }
}
