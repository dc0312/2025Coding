package javaBasics.comparable;

public class Employee implements Comparable {
    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        Employee other = (Employee) o;
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Alice", 30);
        Employee e2 = new Employee("Bob", 25);
        System.out.println(e1.compareTo(e2)); // Output: positive number since 30 > 25
        System.out.println(e2.compareTo(e1)); // Output: negative number since 25 < 30
        System.out.println(e1.compareTo(e1)); // Output: 0 since both ages are equal
    }
}
