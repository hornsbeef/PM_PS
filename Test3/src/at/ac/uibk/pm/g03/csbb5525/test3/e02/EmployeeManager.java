package at.ac.uibk.pm.g03.csbb5525.test3.e02;

import java.util.*;

public class EmployeeManager {

    Set<Employee> employeeSet = new TreeSet<>();    //? könnte in () nach TreeSet noch Comparator angeben?!

    @Override
    public String toString() {
        return employeeSet.toString();
    }

    public void addEmployee(Employee employee){
        if(employee == null) //evtl sinnvoll, hängt aber vom genauen Set Type ab
        {
            throw new IllegalArgumentException("Employee to be added cannot be null");
        }
        //employeeSet.add(employee);
        // alternativ:
        if(!employeeSet.add(employee)){
            throw new IllegalArgumentException("Employee already added");
        }
    }

    public void removeEmployee(Employee employee){
        if(employee == null){
            throw new IllegalArgumentException("Employee to be removed cannot be null");
        }
        //if(!employeeSet.contains(employee)){
        //    throw new IllegalArgumentException("Employee to be removed is not in the Set");
        //}
        //employeeSet.remove(employee);

        //alternative von Prof:
        if(!employeeSet.remove(employee)){
            throw new IllegalArgumentException("Employee to be removed is not in the Set");
        }
    }

    public List<Employee> getEmployees(){
        if(employeeSet.isEmpty()){
            return Collections.emptyList();
        }
        //Treeset: Constructs a new, empty tree set, sorted according to the natural ordering of its elements.
        return new ArrayList<>(employeeSet); //new list so internal list cannot be modified.

        //alternative von Prof:
        //List.copyOf(employeeSet);
    }

    public List<Employee> getEmployeesBySalary(){
        if(employeeSet.isEmpty()){
            return Collections.emptyList();
        }
        List<Employee> employeeList = new ArrayList<>(employeeSet);
       employeeList.sort((e1, e2) -> {
           return Integer.compare(e1.getSalary(), e2.getSalary());
       });
       return employeeList;

       //alternative von Prof:
       //return employeeSet.stream().sorted( (e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary())).toList();


    }

}
