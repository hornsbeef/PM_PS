package at.ac.uibk.pm.g03.csbb5525.test3.e02;

import java.util.Objects;

public class Employee implements Comparable<Employee>{

    private String name;
    private int age;
    private int salary;

    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return age == employee.age && salary == employee.salary && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary);
    }


    @Override
    public int compareTo(Employee o) {
        int nameComparison = this.name.compareTo(o.getName());
        int ageComparison = Integer.compare(this.age, o.getAge());

        if(nameComparison != 0){
            return nameComparison;
        } else if (ageComparison != 0) {
            return ageComparison;
        }else {
            return Integer.compare(this.salary, o.getSalary());
        }
    }

    @Override
    public String toString() {
        return "(%s, %d, %d)".formatted(name, age, salary);
    }
}
