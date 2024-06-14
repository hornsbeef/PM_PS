package at.ac.uibk.pm.g03.csbb5525.test3.e02;

//import at.ac.uibk.pm.g03.csbb5525.test3.e02.Employee;
//import at.ac.uibk.pm.g03.csbb5525.test3.e02.EmployeeManager;

public class Main {
    public static void main(String[] args) {

        Employee e1 = new Employee("e1", 21, 2504);
        Employee e2 = new Employee("e2", 22, 2503);
        Employee e3 = new Employee("e3", 23, 2502);
        Employee e4 = new Employee("e4", 24, 2501);

        EmployeeManager employees = new EmployeeManager();
        employees.addEmployee(e2);
        employees.addEmployee(e1);
        employees.addEmployee(e3);
        employees.addEmployee(e4);

        System.out.println(employees);

        employees.removeEmployee(e1);

        System.out.println(employees);

        employees.addEmployee(e1);
        System.out.println(employees.getEmployees());
        System.out.println(employees.getEmployeesBySalary());

    }
}
