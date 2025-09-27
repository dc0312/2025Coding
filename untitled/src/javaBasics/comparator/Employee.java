package javaBasics.comparator;

import java.util.Comparator;
import java.util.SortedSet;

public class Employee {
    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Deepak", 30);
        Employee e2 = new Employee("Bob", 35);
        System.out.println(e1);
        System.out.println(e2);
        //use Comparator in main class
        SortedSet<Employee> employees = new java.util.TreeSet<>(Comparator.comparing(emp -> emp.age));
        employees.add(e1);
        employees.add(e2);
        System.out.println(employees);
        //use AgeComparator in main class
        SortedSet<Employee> employees2 = new java.util.TreeSet<>(new AgeComparator());
        employees2.add(e1);
        employees2.add(e2);
        System.out.println(employees2);
        //use NameComparator in main class
        SortedSet<Employee> employees3 = new java.util.TreeSet<>(new NameComparator());
        employees3.add(e1);
        employees3.add(e2);
        System.out.println(employees3);
        //use EmployeeComparator in main class
        SortedSet<Employee> employees4 = new java.util.TreeSet<>(new EmployeeComparator());
        employees4.add(e1);
        employees4.add(e2);
        System.out.println(employees4);
    }
}
