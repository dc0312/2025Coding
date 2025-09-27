package javaBasics.comparator;

public class EmployeeComparator implements java.util.Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
       // First compare by age
        int ageComparison = Integer.compare(e1.age, e2.age);
        if (ageComparison != 0) {
            return ageComparison;
        }
        // If ages are equal, compare by name
        return e1.name.compareTo(e2.name);
    }
}
